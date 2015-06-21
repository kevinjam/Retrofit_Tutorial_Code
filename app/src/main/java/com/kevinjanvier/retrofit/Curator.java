package com.kevinjanvier.retrofit;

import java.util.List;

/**
 * Created by user on 6/17/15.
 */
public class Curator {
    public String title;
    public List<Dataset>dataset;


    public class Dataset{
        String curator_title;
        String curator_tagline;
    }
}
