package _18_Stacks_And_Queues.CustomStacks;

//This dynamic stacks never get full.
public class DynamicStacks extends CustomStacks {
    //constructor
   public DynamicStacks(){
       super(); //it will call parent constructor CustomStack()
   }

   //constructor with parameter
    public DynamicStacks(int size){
        super(size); //it will call parent constructor CustomStack(int size)
    }

    //we did override of push method because we don't want to used push from parent class.
    //we want to use push method from dynamicStack class.
     public boolean push(int item){
       //this takes care of it being full.
        if(isFull()){

            //double the array size.
            int [] temp = new int[data.length*2];

            //copy all previous item in new data.
            for (int i=0;i<data.length;i++){
                temp[i] = data[i];
            }

            //temp are assign to the data.
            data = temp;
        }

        //at this point we know that array is not full
        //insert item.
         return super.push(item);//it will call parent push method. To see : ctrl+click on push.
     }
}

//Note :
/*
In dynamic stacks everything will remain the same as CustomStacks the only problems we faced in push.
so, In dynamic stacks we will double the size of the array.
*/