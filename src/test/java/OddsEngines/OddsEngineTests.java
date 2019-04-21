package OddsEngines;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Filename: OddsEngineTests.java
 * Author: Adam Richman, Josh Gulden
 * Purpose: This class contains tests for OddsEngine.java
 * Creation Date: 4/21/19
 * Course Info: CS 1699 - SEC 1115
 * Final Project
 */
class OddsEngineTests {
    /**
     * Tests getVigorishInfo()
     */
    @Test
    void testGetVigorishInfo() {
        OddsEngine m = Mockito.mock(OddsEngine.class);
        when(m.getVigorishInfo(1.05)).thenCallRealMethod();
        when(m.getVigorishInfo(1.00)).thenCallRealMethod();
        when(m.getVigorishInfo(0.50)).thenCallRealMethod();
        assertEquals(0.05, m.getVigorishInfo(1.05), 0);
        assertEquals(0.0, m.getVigorishInfo(1.00), 0);
        assertEquals(0.0, m.getVigorishInfo(0.50), 0);
    }
}
