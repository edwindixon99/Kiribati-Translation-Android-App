package com.ejd.kiribatitranslate;

public class TranslationModel {
    private String englishPhrase;
    private String kiribatiPhrase;

    public TranslationModel(String english, String kiribati)
    {
        this.englishPhrase = english;
        this.kiribatiPhrase = kiribati;
    }

    public String getEnglishPhrase() {
        return englishPhrase;
    }

    public void setEnglishPhrase(String englishPhrase) {
        this.englishPhrase = englishPhrase;
    }

    public String getKiribatiPhrase() {
        return kiribatiPhrase;
    }

    public void setKiribatiPhrase(String kiribatiPhrase) {
        this.kiribatiPhrase = kiribatiPhrase;
    }

    @Override
    public String toString() {
        return "TranslationModel{" +
                "englishPhrase='" + englishPhrase + '\'' +
                ", kiribatiPhrase='" + kiribatiPhrase + '\'' +
                '}';
    }
}

