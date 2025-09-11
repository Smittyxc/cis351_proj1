import org.junit.Assert;
import org.junit.Test;

import static edu.gvsu.dlunit.DLUnit.*;


public class fullAdderTest {
  @Test
  public void zero_zero() {
    for(int i=0; i<=1; i++) {
      for(int j=0; j<=1; j++) {
        for(int h=0; h<=1; h++) {
          setPinUnsigned("InputA", i);
          setPinUnsigned("InputB", j);
          setPinUnsigned("CarryIn", h);
          run();
          
          String errorMessage = "Failed test with input A: " + Integer.toString(i) + ", B: "+ Integer.toString(j) + ", C: "+ Integer.toString(h);

          int total = i + j + h;

          if (total == 0){
            Assert.assertEquals(errorMessage, 0, readPinUnsigned("cOut"));
            Assert.assertEquals(errorMessage, 0, readPinUnsigned("sum"));
          } else if (total == 1) {
            Assert.assertEquals(errorMessage, 0, readPinUnsigned("cOut"));
            Assert.assertEquals(errorMessage, 1, readPinUnsigned("sum"));
          } else if (total == 2) {
            Assert.assertEquals(errorMessage, 1, readPinUnsigned("cOut"));
            Assert.assertEquals(errorMessage, 0, readPinUnsigned("sum"));
          } else if (total == 3) {
            Assert.assertEquals(errorMessage, 1, readPinUnsigned("cOut"));
            Assert.assertEquals(errorMessage, 1, readPinUnsigned("sum"));
          }
        }
      }
    }
    
    
  }

 
}
