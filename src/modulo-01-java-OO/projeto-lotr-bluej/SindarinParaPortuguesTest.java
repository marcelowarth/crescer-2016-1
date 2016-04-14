import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SindarinParaPortuguesTest
{
    @Test
    public void traduzirNaurParaPortugues() {
        //naur
        TradutorSindarin tradutorPortugues = new SindarinParaPortugues();
        assertEquals("fogo", tradutorPortugues.traduzir("naur"));
    }
}
