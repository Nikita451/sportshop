package ru.nikitainfo;


public class BinomRasp {

     private int n;
     private int k;
     private double p;  

       
    public BinomRasp() {
    }
   
    public BinomRasp(int n,int k,double p) {
        this.n = n;
        this.k = k;
        this.p = p;
    }   

    
    public double getP()
    {
        return this.p;
    }
    
    public void setP(double p)
    {
        this.p = p;
    }
    
    public int getK() {
        return k;
    }

   
    public void setK(int k) {
        this.k = k;
    }

    
     
    public int getN() {
        return n;
    }

   
    public void setN(int n) {
        this.n = n;
    }

    public double locTMuavra_Laplasa(int ka)
    {
        double x = (ka-this.n*this.p)/Math.sqrt(this.n*this.p*(1 - this.p));
        double kof = 1/Math.sqrt(2*Math.PI*this.n*this.p*(1-this.p));
        
        double res = kof * Math.exp(-Math.pow(x, 2.0)/2.0);
        return res;
    }
    
    
    public double goodTm()
    {
        double sum = 0.0;
        for (int i=k;i<=n;i++)
        {
            sum+=this.locTMuavra_Laplasa(i);
        }
        
        return sum;
    }
    
    public int chekResult(String my_k,String my_n,String my_p,String my_com)
    {
        double sum = 0.0;
        this.p = (1/Double.valueOf(my_p)) + (Double.valueOf(my_com)/100.0);
        this.k = Integer.valueOf(my_k);
        this.n = Integer.valueOf(my_n);
        
        sum = goodTm();
        
        int res = (int) Math.round(sum*100);
        
        return res;
    }
    
}

