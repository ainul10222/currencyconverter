package com.ainul.currencyconverter.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service for storing conversion history across app views.
 */
public class HistoryService {
    private final List<String> historyEntries;

    public HistoryService() {
        this.historyEntries = new ArrayList<>();
    }

    public void addEntry(String entry) {
        historyEntries.add(0, entry);
    }

    public List<String> getHistoryEntries() {
        return Collections.unmodifiableList(new ArrayList<>(historyEntries));
    }

    public String getHistoryText() {
        return String.join("\n", historyEntries);
    }

    public void clearHistory() {
        historyEntries.clear();
    }

    public boolean hasHistory() {
        return !historyEntries.isEmpty();
    }
}
