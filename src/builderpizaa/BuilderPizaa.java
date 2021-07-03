/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builderpizaa;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class BuilderPizaa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        PizzaBuilder hawai_pizzaBuilder = new HawaiPizzaBuilder();
        PizzaBuilder picante_pizzaBuilder = new PicantePizzaBuilder();
        
        cocina.setPizzaBuilder(hawai_pizzaBuilder);
        cocina.construirPizza();
        
        Pizza pizza = cocina.getPizza();
        System.out.println(pizza.getMasa());
        System.out.println(pizza.getRelleno());
        System.out.println(pizza.getSalsa());
    }
    
}
//Producto
class Pizza{
    private String masa;
    private String salsa;
    private String relleno;

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getMasa() {
        return masa;
    }

    public String getSalsa() {
        return salsa;
    }

    public String getRelleno() {
        return relleno;
    }
    
    
    
}

//Builder abstracto
abstract class PizzaBuilder{
    protected Pizza pizza;
    
    public Pizza getPizza(){
        return pizza;
    }
    public abstract void buildMasa();
    public abstract void buildSalsa();
    public abstract void builRelleno();
    
}

//constructor concreto
class HawaiPizzaBuilder extends PizzaBuilder{

    public HawaiPizzaBuilder() {
    super.pizza = new Pizza();
    }
    
    @Override
    public void buildMasa() {
      pizza.setMasa("suave");
    }

    @Override
    public void buildSalsa() {
         pizza.setSalsa("dulce");
    }

    @Override
    public void builRelleno() {
       pizza.setRelleno("chorizo+alcachofas");
    }   
}

//constructor concreto
class PicantePizzaBuilder extends PizzaBuilder{

    public PicantePizzaBuilder() {
    super.pizza = new Pizza();
    }
    
    @Override
    public void buildMasa() {
      pizza.setMasa("cocido");
    }

    @Override
    public void buildSalsa() {
         pizza.setSalsa("picante");
    }

    @Override
    public void builRelleno() {
       pizza.setRelleno("pimiento+salchichon");
    }
    
}
//Director
class Cocina{
    private PizzaBuilder pizzaBuilder;
    public void setPizzaBuilder(PizzaBuilder pizzaBuilder){
        this.pizzaBuilder = pizzaBuilder;
    }
    public Pizza getPizza(){
        return pizzaBuilder.getPizza();
    }
    public void construirPizza(){
        pizzaBuilder.builRelleno();
        pizzaBuilder.buildMasa();
        pizzaBuilder.buildSalsa();
    }
    
}
