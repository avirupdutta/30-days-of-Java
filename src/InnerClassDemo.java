public class InnerClassDemo {

    public static void main(String args[]){
        Apple.iPhone newIPhone = new Apple.iPhone("iPhone X");
        newIPhone.showModelName();
    }
}

class Apple {

    static String brandName = "Apple Inc.";

    static class iPhone{
        static int totalManufactures = 0;
        private String modelName;

        iPhone(String name){
            modelName = name;
            totalManufactures++;
        }
        public void showModelName(){
            System.out.println(brandName+" has manufactured the iPhone with Model name: "+modelName);
        }
    }

}



