public class Statistiques {
    private int manches;
    private int parties;
    private int victoires;
    private int defaites;
    private int egalites;
    private int victoiremanche;
    private int defaitemanche;



    public Statistiques() {
        manches = 0;
        parties = 0;
        egalites = 0;
        victoires = 0;
        defaites = 0;
        victoiremanche = 0;
        defaitemanche = 0;
    }

    public void ajoutmanche(){
        this.manches = this.manches +1;
    }
    public void ajoutparties(){
        this.parties = this.parties +1;
    }
    public void ajoutvictoire(){
        this.victoires = this.victoires+1;
    }

    public void ajoutdefaites(){
        this.defaites = this.defaites +1;
    }

    public void ajoutegalites(){
        this.egalites = this.egalites + 1;
    }

    public void ajoutvictoiremanche(){
        this.victoiremanche = this.victoiremanche +1;
    }

    public void ajoutdefaitemanche(){
        this.defaitemanche = this.defaitemanche +1;
    }
    public void displaystats(){

        System.out.print("nombre de manches : " + this.manches+"\n");
        System.out.print("nombre de parties : " + this.parties+"\n" );
        System.out.print("nombre de parties perdues : " + this.defaites+"\n" );
        System.out.print("nombre de parties gagnees : " + this.victoires+"\n" );
        System.out.print("nombre de manches nulles : " + this.egalites+"\n" );
        System.out.print("nombre de manches perdues : " + this.defaitemanche+"\n" );
        System.out.print("nombre de manches gagnees : " + this.victoiremanche+"\n" );

        System.out.println();
    }
}
