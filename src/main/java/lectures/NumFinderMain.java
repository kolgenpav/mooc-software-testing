package lectures;

public class NumFinderMain {
    public static void main(String[] args) {
        NumFinderWithBug nfwb = new NumFinderWithBug();

        nfwb.find(new int[]{4, 25, 7, 9});

        System.out.println(nfwb.getLargest());
        System.out.println(nfwb.getSmallest());

        int[] nums = new int[]{4, 3, 2, 1};
        nfwb.find(nums);
        /*Возвращает в качестве максимального элемента 25 - значение при предыдущей проверке.
        Если закомментировать предыдущий поиск, возвращает Integer.MIN_VALUE*/
        System.out.println(nfwb.getLargest());
        System.out.println(nfwb.getSmallest());

        /*Теперь все работает*/
        NumFinder nf = new NumFinder();
        nf.find(nums);
        System.out.println(nf.getLargest());
        System.out.println(nf.getSmallest());
    }
}
