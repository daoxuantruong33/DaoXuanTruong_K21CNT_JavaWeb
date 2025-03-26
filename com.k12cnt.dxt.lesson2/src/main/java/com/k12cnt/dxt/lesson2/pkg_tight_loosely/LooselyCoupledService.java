package com.k12cnt.dxt.lesson2.pkg_tight_loosely;

public class LooselyCoupledService {
    private  SortAlgoristhm sortAlgoristhm;
    public LooselyCoupledService() {}
    public LooselyCoupledService(SortAlgoristhm sortAlgoristhm) {
        this.sortAlgoristhm = sortAlgoristhm;
    }
    public void complexBusiness(int[] array){
        sortAlgoristhm.sort(array);
    }

    public static void main(String[] args) {
        LooselyCoupledService service = new LooselyCoupledService(new LooselyBubbleSortAlgoristhm());
        int[] a={21,23,21,43};
        service.complexBusiness(a);
    }
}

class LooselyBubbleSortAlgoristhm implements SortAlgoristhm{
    @Override
    public void sort(int[] array) {
        System.out.println("Sorted using Bubble Sort algorithm");
    }
}