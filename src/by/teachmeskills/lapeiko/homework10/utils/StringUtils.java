package by.teachmeskills.lapeiko.homework10.utils;

public class StringUtils {
    public static final int CARD_LENGTH = 4 * 4;
    public static final int SECURE_CARD_NUMBER_DIGITS_LENGTH = 4;
    public static final int PASSPORT_SERIES_LENGTH = 2;
    public static final int PASSPORT_DIGITS_LENGTH = 7;
    public static final int PASSPORT_LENGTH = PASSPORT_SERIES_LENGTH + PASSPORT_DIGITS_LENGTH;

    /* Task1
     Пользователи часто в полях ввода оставляют случайные лишние пробелы.
     Создать глобальную (т.е. static) функцию, которая нормализует строку.
     Будем считать строку нормализованной, если: – в начале и в конце строки нет пробелов
     – в строке нет повторяющихся подряд 2 и более символов пробела
     Примеры: “ Hello world ” ➡ “Hello world” “Oleg Grigorijan” ➡ “Oleg Grigorijan” “ “ ➡ “”
     */
    public static String normalizeString(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException("Error. Inadmissible size of line. Try again.");
        }
        while (str.contains("  ")) {
            String replace = str.replace("  ", " ");
            str = replace;
        }
        return str.trim();
    }

    /* Task2
    Создать глобальную функцию, которая номер банковской карты (число из 16 цифр)
    приводит к строке формата “**** **** **** NNNN”, где NNNN – последние 4 цифры номера
    Пример: 1122334455667788 ➡ “**** ** ** 7788”
     */
    public static String getSecureCardNumber(String str) {
        if (str.length() != CARD_LENGTH) {
            throw new IllegalArgumentException("Error. Inadmissible size of card number. Try again.");
        }
        return "**** **** **** " + str.substring(CARD_LENGTH - SECURE_CARD_NUMBER_DIGITS_LENGTH);
    }

    /* Task3
    Создать глобальную функцию, которая принимает 3 строковых значения:
    фамилию, имя, отчество. Функция преобразует их в одну строку формата
    “Фамилия И. О.” Отчества может не существовать, тогда для него придёт пустая строка,
    а в инициалах должно быть только имя. Примеры:
    “Григорьян”, “Олег”, “Игоревич” ➡ “Григорьян О. И.”
    “Смит”, “Джеймс”, “” ➡ “Смит Д.”
     */
    public static String initialsOfName(String lastName, String firstName, String patronymic) {
        if (lastName.isEmpty() || firstName.isEmpty()) {
            throw new IllegalArgumentException("Error. Don't be anonymous. Represent yourself");
        }
        char firstNameLetter = firstName.charAt(0);
        if (patronymic.isEmpty()) {
            return "%s %s.".formatted(lastName, firstNameLetter);
        } else {
            char patronymicLetter = patronymic.charAt(0);
            return "%s %s. %s.".formatted(lastName, firstNameLetter, patronymicLetter);
        }
    }

    /* Task4
    Создать глобальную функцию, которая проверяет,
    является ли строка верным номером белорусского паспорта.
    Номером паспорта считаем строку из 2-ух английских букв верхнего
    регистра и 7 цифр Примеры: “MP1234567” ➡ Да “MP123456” ➡ Нет “PPP234567”
    ➡ Нет “ЯЯ1234567” ➡ Нет “PP123456P” ➡ Нет “mp1234567" ➡ Нет
     */

    public static boolean isRightNumberOfBelPassport(String str) {
        if (str.length() != PASSPORT_LENGTH) {
            return false;
        }
        for (int i = 0; i < PASSPORT_SERIES_LENGTH; i++) {
            if (!(str.charAt(0) >= 'A' && str.charAt(0) <= 'Z' &&
                    str.charAt(1) >= 'A' && str.charAt(1) <= 'Z')) {
                return false;
            }
        }
        for (int j = PASSPORT_SERIES_LENGTH; j < PASSPORT_LENGTH; j++) {
            if (!(str.charAt(j) > '0' && str.charAt(j) <= '9')) {
                return false;
            }
        }
        return true;
    }

    /* Task5
    Создать глобальную функцию, которая проверяет, является ли
    придуманный пароль достаточно надёжным. Надёжным считаем пароль,
    если он: – содержит 8 и более символов – содержит хотя бы одну
    букву нижнего регистра – содержит хотя бы одну букву верхнего
    регистра – содержит хотя бы одну цифру.
    Примеры: “aaHlo2pm” ➡ Да “ouM-MLL23pm?Hlss” ➡ Да “бянтык23длШ”
    ➡ Да “dslfjdsljdslfjldsgjlgdsdsj” ➡ Нет “HHON83LD” ➡ Нет “aH3l” ➡ Нет
     */
    public static boolean isReliablePassword(String str) {
        boolean isReliable = false;
        if (str.length() >= 8) {
            char[] chars = str.toCharArray();
            boolean hasLower = false;
            boolean hasUpper = false;
            boolean hasDigit = false;
            for (int i = 0; i < chars.length; i++) {
                if (!hasLower && Character.isLowerCase(i)) {
                    hasLower = true;
                }
                if (!hasUpper && Character.isUpperCase(i)) {
                    hasUpper = true;
                }
                if (!hasDigit && Character.isDigit(i)) {
                    hasDigit = true;
                }
                if (hasLower && hasUpper && hasDigit) {
                    isReliable = true;
                    break;
                }
            }
        }
        return isReliable;
    }

    /* Task6
    Создать глобальную функцию, которая проверяет, является ли
    строка подобием email адреса. Считаем строку подобием email
    адреса, если она: – не содержит пробелов – содержит один
    и только один символ ‘@‘ – символ ‘@’ окружён хотя бы
    одним символом с каждой стороны. Примеры: “oleg.grigorijan@gmail.com”
    ➡ Да “a@a” ➡ Да “@ab” ➡ Нет “ab@” ➡ Нет “abc“ ➡ Нет “a bc@gmail.com”
    ➡ Нет “abc@abc@gmail.com” ➡ Нет
     */
    public static boolean isSimilarStringToEmail(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException("Error. Don't be anonymous. Write your email.");
        }
        int atIndex = str.indexOf('@');
        if (atIndex != -1 && !str.contains(" ")) {
            if (atIndex == str.lastIndexOf('@')) {
                return atIndex < str.length() - 1 && atIndex > 0;
            }
        }
        return false;
    }
}
