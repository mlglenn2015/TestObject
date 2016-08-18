package prv.mark.test.domain;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by mlglenn on 8/18/2016.
 */
public class BinaryNumberTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryNumberTests.class);
    private static final int DECIMAL_RADIX = 2;
    private static final int OCTAL_RADIX = 8;
    private static final int HEXADECIMAL_RADIX = 16;

    @Before
    public void setup() {
        LOGGER.debug("BinaryNumberTests.setup()");
    }

    @Test
    public void testDecimal999ToBinary() {
        int decimalVal = 999;
        String binaryVal = decToBin(decimalVal);
        assertNotNull(binaryVal);
        assertEquals(binaryVal, "1111100111");
        LOGGER.debug("Binary Value for Decimal {} : {}", decimalVal, binaryVal);
    }
    /*
    08-18-2016 11:04:29.882 DEBUG p.mark.test.domain.BinaryNumberTests - BinaryNumberTests.setup()
08-18-2016 11:04:29.886 DEBUG p.mark.test.domain.BinaryNumberTests - Binary Value for Decimal 999 : 1111100111
     */

    @Test
    public void testBinaryToDecimal() {
        String binaryVal = "1111100111";
        int decimalVal = binToDec(binaryVal);
        assertNotNull(decimalVal);
        assertEquals(decimalVal, 999);
        LOGGER.debug("Decimal Value for Binary {} : {}", binaryVal, decimalVal);
    }
    /*
    08-18-2016 11:03:50.763 DEBUG p.mark.test.domain.BinaryNumberTests - BinaryNumberTests.setup()
08-18-2016 11:04:04.842 DEBUG p.mark.test.domain.BinaryNumberTests - Decimal Value for Binary 1111100111 : 999
     */

    @Test
    public void testListDecimalBinaryTable() {
        for (int i=0; i<100; i++) {
            LOGGER.debug("DECIMAL:{} BINARY:{}", i, decToBin(i));
        }
    }
    /*
08-18-2016 11:15:11.651 DEBUG p.mark.test.domain.BinaryNumberTests - BinaryNumberTests.setup()
08-18-2016 11:15:11.654 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:0 BINARY:0
08-18-2016 11:15:11.655 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:1 BINARY:1
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:2 BINARY:10
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:3 BINARY:11
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:4 BINARY:100
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:5 BINARY:101
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:6 BINARY:110
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:7 BINARY:111
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:8 BINARY:1000
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:9 BINARY:1001
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:10 BINARY:1010
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:11 BINARY:1011
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:12 BINARY:1100
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:13 BINARY:1101
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:14 BINARY:1110
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:15 BINARY:1111
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:16 BINARY:10000
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:17 BINARY:10001
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:18 BINARY:10010
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:19 BINARY:10011
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:20 BINARY:10100
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:21 BINARY:10101
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:22 BINARY:10110
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:23 BINARY:10111
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:24 BINARY:11000
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:25 BINARY:11001
08-18-2016 11:15:11.656 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:26 BINARY:11010
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:27 BINARY:11011
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:28 BINARY:11100
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:29 BINARY:11101
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:30 BINARY:11110
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:31 BINARY:11111
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:32 BINARY:100000
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:33 BINARY:100001
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:34 BINARY:100010
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:35 BINARY:100011
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:36 BINARY:100100
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:37 BINARY:100101
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:38 BINARY:100110
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:39 BINARY:100111
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:40 BINARY:101000
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:41 BINARY:101001
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:42 BINARY:101010
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:43 BINARY:101011
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:44 BINARY:101100
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:45 BINARY:101101
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:46 BINARY:101110
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:47 BINARY:101111
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:48 BINARY:110000
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:49 BINARY:110001
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:50 BINARY:110010
08-18-2016 11:15:11.657 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:51 BINARY:110011
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:52 BINARY:110100
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:53 BINARY:110101
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:54 BINARY:110110
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:55 BINARY:110111
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:56 BINARY:111000
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:57 BINARY:111001
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:58 BINARY:111010
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:59 BINARY:111011
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:60 BINARY:111100
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:61 BINARY:111101
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:62 BINARY:111110
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:63 BINARY:111111
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:64 BINARY:1000000
08-18-2016 11:15:11.658 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:65 BINARY:1000001
08-18-2016 11:15:11.659 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:66 BINARY:1000010
08-18-2016 11:15:11.660 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:67 BINARY:1000011
08-18-2016 11:15:11.660 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:68 BINARY:1000100
08-18-2016 11:15:11.660 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:69 BINARY:1000101
08-18-2016 11:15:11.660 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:70 BINARY:1000110
08-18-2016 11:15:11.660 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:71 BINARY:1000111
08-18-2016 11:15:11.660 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:72 BINARY:1001000
08-18-2016 11:15:11.660 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:73 BINARY:1001001
08-18-2016 11:15:11.660 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:74 BINARY:1001010
08-18-2016 11:15:11.660 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:75 BINARY:1001011
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:76 BINARY:1001100
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:77 BINARY:1001101
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:78 BINARY:1001110
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:79 BINARY:1001111
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:80 BINARY:1010000
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:81 BINARY:1010001
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:82 BINARY:1010010
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:83 BINARY:1010011
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:84 BINARY:1010100
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:85 BINARY:1010101
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:86 BINARY:1010110
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:87 BINARY:1010111
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:88 BINARY:1011000
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:89 BINARY:1011001
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:90 BINARY:1011010
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:91 BINARY:1011011
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:92 BINARY:1011100
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:93 BINARY:1011101
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:94 BINARY:1011110
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:95 BINARY:1011111
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:96 BINARY:1100000
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:97 BINARY:1100001
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:98 BINARY:1100010
08-18-2016 11:15:11.661 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:99 BINARY:1100011
     */

    @Test
    public void testDecimal999ToHexadecimal() {
        int decimalVal = 999;
        String hexVal = decToHex(decimalVal);
        assertNotNull(hexVal);
        assertEquals(hexVal, "3E7");
        LOGGER.debug("Hexadecimal Value for Decimal {} : {}", decimalVal, hexVal);
    }
    /*
    08-18-2016 11:06:41.295 DEBUG p.mark.test.domain.BinaryNumberTests - BinaryNumberTests.setup()
08-18-2016 11:06:41.302 DEBUG p.mark.test.domain.BinaryNumberTests - Hexadecimal Value for Decimal 999 : 3E7
     */

    @Test
    public void testHexadecimalToDecimal() {
        String hexVal = "3E7";
        int decimalVal = hexToDec(hexVal);
        assertNotNull(decimalVal);
        assertEquals(decimalVal, 999);
        LOGGER.debug("Decimal Value for Hexadecimal {} : {}", decimalVal, hexVal);
    }
    /*
08-18-2016 11:10:37.654 DEBUG p.mark.test.domain.BinaryNumberTests - BinaryNumberTests.setup()
08-18-2016 11:10:48.390 DEBUG p.mark.test.domain.BinaryNumberTests - Decimal Value for Hexadecimal 999 : 3E7
     */

    @Test
    public void testListDecimalHexadecimalTable() {
        for (int i=0; i<100; i++) {
            LOGGER.debug("DECIMAL:{} HEXADECIMAL:{}", i, decToHex(i));
        }
    }
    /*
08-18-2016 11:56:00.629 DEBUG p.mark.test.domain.BinaryNumberTests - BinaryNumberTests.setup()
08-18-2016 11:56:00.635 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:0 HEXADECIMAL:0
08-18-2016 11:56:00.637 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:1 HEXADECIMAL:1
08-18-2016 11:56:00.637 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:2 HEXADECIMAL:2
08-18-2016 11:56:00.637 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:3 HEXADECIMAL:3
08-18-2016 11:56:00.637 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:4 HEXADECIMAL:4
08-18-2016 11:56:00.637 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:5 HEXADECIMAL:5
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:6 HEXADECIMAL:6
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:7 HEXADECIMAL:7
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:8 HEXADECIMAL:8
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:9 HEXADECIMAL:9
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:10 HEXADECIMAL:A
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:11 HEXADECIMAL:B
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:12 HEXADECIMAL:C
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:13 HEXADECIMAL:D
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:14 HEXADECIMAL:E
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:15 HEXADECIMAL:F
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:16 HEXADECIMAL:10
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:17 HEXADECIMAL:11
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:18 HEXADECIMAL:12
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:19 HEXADECIMAL:13
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:20 HEXADECIMAL:14
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:21 HEXADECIMAL:15
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:22 HEXADECIMAL:16
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:23 HEXADECIMAL:17
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:24 HEXADECIMAL:18
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:25 HEXADECIMAL:19
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:26 HEXADECIMAL:1A
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:27 HEXADECIMAL:1B
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:28 HEXADECIMAL:1C
08-18-2016 11:56:00.638 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:29 HEXADECIMAL:1D
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:30 HEXADECIMAL:1E
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:31 HEXADECIMAL:1F
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:32 HEXADECIMAL:20
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:33 HEXADECIMAL:21
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:34 HEXADECIMAL:22
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:35 HEXADECIMAL:23
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:36 HEXADECIMAL:24
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:37 HEXADECIMAL:25
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:38 HEXADECIMAL:26
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:39 HEXADECIMAL:27
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:40 HEXADECIMAL:28
08-18-2016 11:56:00.639 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:41 HEXADECIMAL:29
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:42 HEXADECIMAL:2A
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:43 HEXADECIMAL:2B
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:44 HEXADECIMAL:2C
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:45 HEXADECIMAL:2D
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:46 HEXADECIMAL:2E
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:47 HEXADECIMAL:2F
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:48 HEXADECIMAL:30
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:49 HEXADECIMAL:31
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:50 HEXADECIMAL:32
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:51 HEXADECIMAL:33
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:52 HEXADECIMAL:34
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:53 HEXADECIMAL:35
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:54 HEXADECIMAL:36
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:55 HEXADECIMAL:37
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:56 HEXADECIMAL:38
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:57 HEXADECIMAL:39
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:58 HEXADECIMAL:3A
08-18-2016 11:56:00.640 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:59 HEXADECIMAL:3B
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:60 HEXADECIMAL:3C
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:61 HEXADECIMAL:3D
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:62 HEXADECIMAL:3E
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:63 HEXADECIMAL:3F
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:64 HEXADECIMAL:40
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:65 HEXADECIMAL:41
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:66 HEXADECIMAL:42
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:67 HEXADECIMAL:43
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:68 HEXADECIMAL:44
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:69 HEXADECIMAL:45
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:70 HEXADECIMAL:46
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:71 HEXADECIMAL:47
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:72 HEXADECIMAL:48
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:73 HEXADECIMAL:49
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:74 HEXADECIMAL:4A
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:75 HEXADECIMAL:4B
08-18-2016 11:56:00.641 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:76 HEXADECIMAL:4C
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:77 HEXADECIMAL:4D
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:78 HEXADECIMAL:4E
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:79 HEXADECIMAL:4F
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:80 HEXADECIMAL:50
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:81 HEXADECIMAL:51
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:82 HEXADECIMAL:52
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:83 HEXADECIMAL:53
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:84 HEXADECIMAL:54
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:85 HEXADECIMAL:55
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:86 HEXADECIMAL:56
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:87 HEXADECIMAL:57
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:88 HEXADECIMAL:58
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:89 HEXADECIMAL:59
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:90 HEXADECIMAL:5A
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:91 HEXADECIMAL:5B
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:92 HEXADECIMAL:5C
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:93 HEXADECIMAL:5D
08-18-2016 11:56:00.642 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:94 HEXADECIMAL:5E
08-18-2016 11:56:00.643 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:95 HEXADECIMAL:5F
08-18-2016 11:56:00.643 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:96 HEXADECIMAL:60
08-18-2016 11:56:00.643 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:97 HEXADECIMAL:61
08-18-2016 11:56:00.643 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:98 HEXADECIMAL:62
08-18-2016 11:56:00.643 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:99 HEXADECIMAL:63
     */


    @Test
    public void testDecimal999ToOctal() {
        int decimalVal = 999;
        String octalVal = decToOct(decimalVal);
        assertNotNull(octalVal);
        assertEquals(octalVal, "1747");
        LOGGER.debug("Octal Value for Decimal {} : {}", decimalVal, octalVal);
    }
    /*
08-18-2016 12:02:05.075 DEBUG p.mark.test.domain.BinaryNumberTests - BinaryNumberTests.setup()
08-18-2016 12:02:05.080 DEBUG p.mark.test.domain.BinaryNumberTests - Octal Value for Decimal 999 : 1747
     */

    @Test
    public void testOctalToDecimal() {
        String octalVal = "1747";
        int decimalVal = octToDec(octalVal);
        assertNotNull(decimalVal);
        assertEquals(decimalVal, 999);
        LOGGER.debug("Decimal Value for Octal {} : {}", octalVal, decimalVal);
    }
    /*
08-18-2016 12:02:26.206 DEBUG p.mark.test.domain.BinaryNumberTests - BinaryNumberTests.setup()
08-18-2016 12:02:26.210 DEBUG p.mark.test.domain.BinaryNumberTests - Decimal Value for Octal 1747 : 999
     */

    @Test
    public void testListDecimalOctalTable() {
        for (int i=0; i<100; i++) {
            LOGGER.debug("DECIMAL:{} OCTAL:{}", i, decToOct(i));
        }
    }
    /*
08-18-2016 12:02:45.111 DEBUG p.mark.test.domain.BinaryNumberTests - BinaryNumberTests.setup()
08-18-2016 12:02:45.116 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:0 OCTAL:0
08-18-2016 12:02:45.117 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:1 OCTAL:1
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:2 OCTAL:2
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:3 OCTAL:3
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:4 OCTAL:4
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:5 OCTAL:5
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:6 OCTAL:6
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:7 OCTAL:7
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:8 OCTAL:10
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:9 OCTAL:11
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:10 OCTAL:12
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:11 OCTAL:13
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:12 OCTAL:14
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:13 OCTAL:15
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:14 OCTAL:16
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:15 OCTAL:17
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:16 OCTAL:20
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:17 OCTAL:21
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:18 OCTAL:22
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:19 OCTAL:23
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:20 OCTAL:24
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:21 OCTAL:25
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:22 OCTAL:26
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:23 OCTAL:27
08-18-2016 12:02:45.118 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:24 OCTAL:30
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:25 OCTAL:31
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:26 OCTAL:32
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:27 OCTAL:33
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:28 OCTAL:34
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:29 OCTAL:35
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:30 OCTAL:36
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:31 OCTAL:37
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:32 OCTAL:40
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:33 OCTAL:41
08-18-2016 12:02:45.119 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:34 OCTAL:42
08-18-2016 12:02:45.120 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:35 OCTAL:43
08-18-2016 12:02:45.120 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:36 OCTAL:44
08-18-2016 12:02:45.120 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:37 OCTAL:45
08-18-2016 12:02:45.120 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:38 OCTAL:46
08-18-2016 12:02:45.120 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:39 OCTAL:47
08-18-2016 12:02:45.120 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:40 OCTAL:50
08-18-2016 12:02:45.120 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:41 OCTAL:51
08-18-2016 12:02:45.121 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:42 OCTAL:52
08-18-2016 12:02:45.121 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:43 OCTAL:53
08-18-2016 12:02:45.121 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:44 OCTAL:54
08-18-2016 12:02:45.122 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:45 OCTAL:55
08-18-2016 12:02:45.122 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:46 OCTAL:56
08-18-2016 12:02:45.122 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:47 OCTAL:57
08-18-2016 12:02:45.122 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:48 OCTAL:60
08-18-2016 12:02:45.122 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:49 OCTAL:61
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:50 OCTAL:62
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:51 OCTAL:63
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:52 OCTAL:64
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:53 OCTAL:65
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:54 OCTAL:66
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:55 OCTAL:67
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:56 OCTAL:70
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:57 OCTAL:71
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:58 OCTAL:72
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:59 OCTAL:73
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:60 OCTAL:74
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:61 OCTAL:75
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:62 OCTAL:76
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:63 OCTAL:77
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:64 OCTAL:100
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:65 OCTAL:101
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:66 OCTAL:102
08-18-2016 12:02:45.123 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:67 OCTAL:103
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:68 OCTAL:104
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:69 OCTAL:105
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:70 OCTAL:106
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:71 OCTAL:107
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:72 OCTAL:110
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:73 OCTAL:111
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:74 OCTAL:112
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:75 OCTAL:113
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:76 OCTAL:114
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:77 OCTAL:115
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:78 OCTAL:116
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:79 OCTAL:117
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:80 OCTAL:120
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:81 OCTAL:121
08-18-2016 12:02:45.124 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:82 OCTAL:122
08-18-2016 12:02:45.125 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:83 OCTAL:123
08-18-2016 12:02:45.125 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:84 OCTAL:124
08-18-2016 12:02:45.125 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:85 OCTAL:125
08-18-2016 12:02:45.125 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:86 OCTAL:126
08-18-2016 12:02:45.125 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:87 OCTAL:127
08-18-2016 12:02:45.125 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:88 OCTAL:130
08-18-2016 12:02:45.125 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:89 OCTAL:131
08-18-2016 12:02:45.125 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:90 OCTAL:132
08-18-2016 12:02:45.126 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:91 OCTAL:133
08-18-2016 12:02:45.126 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:92 OCTAL:134
08-18-2016 12:02:45.126 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:93 OCTAL:135
08-18-2016 12:02:45.126 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:94 OCTAL:136
08-18-2016 12:02:45.126 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:95 OCTAL:137
08-18-2016 12:02:45.126 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:96 OCTAL:140
08-18-2016 12:02:45.126 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:97 OCTAL:141
08-18-2016 12:02:45.127 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:98 OCTAL:142
08-18-2016 12:02:45.127 DEBUG p.mark.test.domain.BinaryNumberTests - DECIMAL:99 OCTAL:143
     */



    private String decToBin(int decimalVal) {
        return Integer.toBinaryString(decimalVal);
    }

    private int binToDec(String binaryVal) {
        return Integer.parseInt(binaryVal, DECIMAL_RADIX);
    }

    private String decToHex(int decimalVal) {
        return Integer.toHexString(decimalVal).toUpperCase();
    }

    private int hexToDec(String hexVal) {
        return Integer.parseInt(hexVal, HEXADECIMAL_RADIX);
    }

    private String decToOct(int decimalVal) {
        return Integer.toOctalString(decimalVal);
    }

    private int octToDec(String hexVal) {
        return Integer.parseInt(hexVal, OCTAL_RADIX);
    }
}
