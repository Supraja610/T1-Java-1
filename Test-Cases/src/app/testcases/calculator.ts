export class Calculator{

    calc1(num : number){
        if(num < 0)
            return 0;
        else
            return num + 1;
    }

    calc2(num:number){
        return Math.sqrt(num);
    }

}