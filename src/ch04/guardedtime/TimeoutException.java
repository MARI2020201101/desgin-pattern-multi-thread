package ch04.guardedtime;

class TimeoutException extends InterruptedException{
   public TimeoutException(String msg){
    super(msg);
   }
}
