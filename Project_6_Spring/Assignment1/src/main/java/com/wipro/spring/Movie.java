package com.wipro.spring;
public class Movie {
 private String movieId, movieName, movieActor;
 public String getMovieId(){return movieId;} public void setMovieId(String v){movieId=v;}
 public String getMovieName(){return movieName;} public void setMovieName(String v){movieName=v;}
 public String getMovieActor(){return movieActor;} public void setMovieActor(String v){movieActor=v;}
 @Override public String toString(){return "Movie ID: "+movieId+"\nMovie Name: "+movieName+"\nMovie Actor: "+movieActor;}
}