public class Account {  //账户类,用来开户
    public AccountState state;
    public String owner;
    public Account(String owner,double init) {
        this.owner = owner;
        this.state=new GreenState(init,this);
        System.out.println(owner+"开户了,初始金额为"+init);
        System.out.println("===============================");
    }
    public void setState(AccountState state){
        this.state=state;
    }
    public void deposit(double amount){
        System.out.println(this.owner+"存款"+amount);
        state.deposit(amount);
        System.out.println("现在账户的状态为"+state.getClass().getName());
        System.out.println("===============================");
    }
    public void withdraw(double amount){
        System.out.println(this.owner+"取款"+amount);
        state.withdraw(amount);
        System.out.println("现在账户的状态为"+state.getClass().getName());
        System.out.println("===============================");
    }
}
