public class Main {
    public static void main(String[] args) {
        Mercadinho mercadinho = new Mercadinho();
        ClienteRegular regular = new ClienteRegular("João", 100);
        ClienteVip vip = new ClienteVip("Felipe", 100, "123");
        ClienteVipOuro ouro = new ClienteVipOuro("Santos", 100, "456", "Rua tal");

        mercadinho.add(regular);
        mercadinho.add(ouro);
        mercadinho.add(vip);

        mercadinho.imprimirClientes();

        System.out.println(mercadinho.valorTotal());        
    }
}
