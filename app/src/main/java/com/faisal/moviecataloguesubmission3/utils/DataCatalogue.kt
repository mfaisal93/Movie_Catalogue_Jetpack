package com.faisal.moviecataloguesubmission3.utils

import com.faisal.moviecataloguesubmission3.data.source.local.entity.TvShowEntity
import com.faisal.moviecataloguesubmission3.data.source.remote.response.MovieResponse
import com.faisal.moviecataloguesubmission3.data.source.remote.response.TvShowResponse
import com.faisal.moviecataloguesubmission3.data.source.local.entity.MovieEntity

object DataCatalogue {

    fun generateMovie(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(1,
                "Aquaman",
                "poster_aquaman",
                "October 7, 2018",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm s half-human, half-Atlantean brother and true heir to the throne.",
                "68%"
            )
        )
        movies.add(
            MovieEntity(1,
                "Bumblebee",
                "poster_bumblebee",
                "December 15, 2018",
                "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.",
                "64%"
            )
        )
        movies.add(
            MovieEntity(1,
                "Once Upon a Deadpool",
                "poster_deadpool",
                "December 11, 2018",
                "A kidnapped Fred Savage is forced to endure Deadpools PG-13 rendition of Deadpool 2 as a Princess Bride-esque story thats full of magic, wonder and zero F s.",
                "70%"
            )
        )
        movies.add(
            MovieEntity(1,
                "How to Train Your Dragon: The Hidden Wolrd",
                "poster_dragon",
                "January 3, 2019",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "76%"
            )
        )
        movies.add(
            MovieEntity(1,
                "Dragon Ball Super: Broly",
                "poster_dragon_ball",
                "December 14, 2018",
                "Earth is peaceful following the Tournament of Power. Realizing that the universes still hold many more strong people yet to see, Goku spends all his days training to reach even greater heights. Then one day, Goku and Vegeta are faced by a Saiyan called Broly who they ve never seen before. The Saiyans were supposed to have been almost completely wiped out in the destruction of Planet Vegeta, so whats this one doing on Earth? This encounter between the three Saiyans who have followed completely different destinies turns into a stupendous battle, with even Frieza (back from Hell) getting caught up in the mix.",
                "75%"
            )
        )
        movies.add(
            MovieEntity(1,
                "Marry Poppins Returns",
                "poster_marrypopins",
                "December 13, 2018",
                "In Depression-era London, a now-grown Jane and Michael Banks, along with Michael s three children, are visited by the enigmatic Mary Poppins following a personal loss. Through her unique magical skills, and with the aid of her friend Jack, she helps the family rediscover the joy and wonder missing in their lives.",
                "67%"
            )
        )
        movies.add(
            MovieEntity(1,
                "Preman Pensiun",
                "poster_preman",
                "January 17, 2019",
                "We dont have an overview translated in English. Help us expand our database by adding one.",
                "66%"
            )
        )
        movies.add(
            MovieEntity(1,
                "Robin Hood",
                "poster_robinhood",
                "November 20, 2018",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "57%"
            )
        )
        movies.add(
            MovieEntity(1,
                "Spider-Man: Into the Spider-Verse",
                "poster_spiderman",
                "December 7, 2018",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson Kingpin Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "84%"
            )
        )
        movies.add(
            MovieEntity(1,
                "Venom",
                "poster_venom",
                "September 28, 2018",
                "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                "66%"
            )
        )

        return movies
    }

    fun generateRemoteMovie(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(1,
                "Aquaman",
                "poster_aquaman",
                "October 7, 2018",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm s half-human, half-Atlantean brother and true heir to the throne.",
                "68%"
            )
        )
        movies.add(
            MovieResponse(1,
                "Bumblebee",
                "poster_bumblebee",
                "December 15, 2018",
                "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.",
                "64%"
            )
        )
        movies.add(
            MovieResponse(1,
                "Once Upon a Deadpool",
                "poster_deadpool",
                "December 11, 2018",
                "A kidnapped Fred Savage is forced to endure Deadpools PG-13 rendition of Deadpool 2 as a Princess Bride-esque story thats full of magic, wonder and zero F s.",
                "70%"
            )
        )
        movies.add(
            MovieResponse(1,
                "How to Train Your Dragon: The Hidden Wolrd",
                "poster_dragon",
                "January 3, 2019",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "76%"
            )
        )
        movies.add(
            MovieResponse(1,
                "Dragon Ball Super: Broly",
                "poster_dragon_ball",
                "December 14, 2018",
                "Earth is peaceful following the Tournament of Power. Realizing that the universes still hold many more strong people yet to see, Goku spends all his days training to reach even greater heights. Then one day, Goku and Vegeta are faced by a Saiyan called Broly who they ve never seen before. The Saiyans were supposed to have been almost completely wiped out in the destruction of Planet Vegeta, so whats this one doing on Earth? This encounter between the three Saiyans who have followed completely different destinies turns into a stupendous battle, with even Frieza (back from Hell) getting caught up in the mix.",
                "75%"
            )
        )
        movies.add(
            MovieResponse(1,
                "Marry Poppins Returns",
                "poster_marrypopins",
                "December 13, 2018",
                "In Depression-era London, a now-grown Jane and Michael Banks, along with Michael s three children, are visited by the enigmatic Mary Poppins following a personal loss. Through her unique magical skills, and with the aid of her friend Jack, she helps the family rediscover the joy and wonder missing in their lives.",
                "67%"
            )
        )
        movies.add(
            MovieResponse(1,
                "Preman Pensiun",
                "poster_preman",
                "January 17, 2019",
                "We dont have an overview translated in English. Help us expand our database by adding one.",
                "66%"
            )
        )
        movies.add(
            MovieResponse(1,
                "Robin Hood",
                "poster_robinhood",
                "November 20, 2018",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "57%"
            )
        )
        movies.add(
            MovieResponse(1,
                "Spider-Man: Into the Spider-Verse",
                "poster_spiderman",
                "December 7, 2018",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson Kingpin Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "84%"
            )
        )
        movies.add(
            MovieResponse(1,
                "Venom",
                "poster_venom",
                "September 28, 2018",
                "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                "66%"
            )
        )

        return movies
    }


    fun generateTvShow(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(1,
                "Goblin Slayer",
                "goblin_slayer",
                "December 7, 2018",
                "A young priestess has formed her first adventuring party, but almost immediately they find themselves in distress. It s the Goblin Slayer who comes to their rescueâ€”a man who s dedicated his life to the extermination of all goblins, by any means necessary. And when rumors of his feats begin to circulate, there s no telling who might come calling next",
                "79%"
            )
        )
        tvShows.add(
            TvShowEntity(1,
                "Lost in Space",
                "lost_in_space",
                "April 13, 2018",
                "After crash-landing on an alien planet, the Robinson family fights against all odds to survive and escape. But they re surrounded by hidden dangers.",
                "69%"
            )
        )
        tvShows.add(
            TvShowEntity(1,
                "Killing Eve",
                "kiling_eve",
                "April 8, 2018",
                "A security consultant hunts for a ruthless assassin. Equally obsessed with each other, they go head to head in an epic game of cat-and-mouse.",
                "80%"
            )
        )
        tvShows.add(
            TvShowEntity(1,
                "Station 19",
                "station_19",
                "March 22, 2018",
                "A group of heroic firefighters at Seattle Fire Station 19â€”from captain to newest recruitâ€”risk their lives and hearts both in the line of duty and off the clock. These brave men and women are like family, literally and figuratively, and together they put their own lives in jeopardy as first responders to save the lives of others.",
                "76%"
            )
        )
        tvShows.add(
            TvShowEntity(1,
                "The Resident",
                "the_resident",
                "January 21, 2018",
                "A tough, brilliant senior resident guides an idealistic young doctor through his first day, pulling back the curtain on what really happens, both good and bad, in modern-day medicine.",
                "73%"
            )
        )
        tvShows.add(
            TvShowEntity(1,
                "Cobra Kai",
                "cobra_kai",
                "May 2, 2018",
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "84%"
            )
        )
        tvShows.add(
            TvShowEntity(1,
                "Barry",
                "bary",
                "March 25, 2018",
                "A hit man from the Midwest moves to Los Angeles and gets caught up in the city s theatre arts scene.",
                "75%"
            )
        )
        tvShows.add(
            TvShowEntity(1,
                "New Amsterdam",
                "new_amsterdam",
                "September 25, 2018",
                "Dr. Max Goodwin, the hospital s newest medical director, sets out to tear up the bureaucracy and provide exceptional care.",
                "73%"
            )
        )
        tvShows.add(
            TvShowEntity(1,
                "Violet Evergarden",
                "violet_evergarden",
                "January 11, 2018",
                "The war is over, and Violet Evergarden needs a job. Scarred and emotionless, she takes a job as a letter writer to understand herself and her past.",
                "85%"
            )
        )
        tvShows.add(
            TvShowEntity(1,
                "Titans",
                "titans",
                "October 12, 2018",
                "A team of young superheroes led by Nightwing (formerly Batman s first Robin) form to combat evil and other perils.",
                "71%"
            )
        )

        return tvShows
    }

    fun generateRemoteTvShow(): List<TvShowResponse> {
        val tvShows = ArrayList<TvShowResponse>()

        tvShows.add(
            TvShowResponse(1,
                "Goblin Slayer",
                "goblin_slayer",
                "December 7, 2018",
                "A young priestess has formed her first adventuring party, but almost immediately they find themselves in distress. It s the Goblin Slayer who comes to their rescueâ€”a man who s dedicated his life to the extermination of all goblins, by any means necessary. And when rumors of his feats begin to circulate, there s no telling who might come calling next",
                "79%"
            )
        )
        tvShows.add(
            TvShowResponse(1,
                "Lost in Space",
                "lost_in_space",
                "April 13, 2018",
                "After crash-landing on an alien planet, the Robinson family fights against all odds to survive and escape. But they re surrounded by hidden dangers.",
                "69%"
            )
        )
        tvShows.add(
            TvShowResponse(1,
                "Killing Eve",
                "kiling_eve",
                "April 8, 2018",
                "A security consultant hunts for a ruthless assassin. Equally obsessed with each other, they go head to head in an epic game of cat-and-mouse.",
                "80%"
            )
        )
        tvShows.add(
            TvShowResponse(1,
                "Station 19",
                "station_19",
                "March 22, 2018",
                "A group of heroic firefighters at Seattle Fire Station 19â€”from captain to newest recruitâ€”risk their lives and hearts both in the line of duty and off the clock. These brave men and women are like family, literally and figuratively, and together they put their own lives in jeopardy as first responders to save the lives of others.",
                "76%"
            )
        )
        tvShows.add(
            TvShowResponse(1,
                "The Resident",
                "the_resident",
                "January 21, 2018",
                "A tough, brilliant senior resident guides an idealistic young doctor through his first day, pulling back the curtain on what really happens, both good and bad, in modern-day medicine.",
                "73%"
            )
        )
        tvShows.add(
            TvShowResponse(1,
                "Cobra Kai",
                "cobra_kai",
                "May 2, 2018",
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "84%"
            )
        )
        tvShows.add(
            TvShowResponse(1,
                "Barry",
                "bary",
                "March 25, 2018",
                "A hit man from the Midwest moves to Los Angeles and gets caught up in the city s theatre arts scene.",
                "75%"
            )
        )
        tvShows.add(
            TvShowResponse(1,
                "New Amsterdam",
                "new_amsterdam",
                "September 25, 2018",
                "Dr. Max Goodwin, the hospital s newest medical director, sets out to tear up the bureaucracy and provide exceptional care.",
                "73%"
            )
        )
        tvShows.add(
            TvShowResponse(1,
                "Violet Evergarden",
                "violet_evergarden",
                "January 11, 2018",
                "The war is over, and Violet Evergarden needs a job. Scarred and emotionless, she takes a job as a letter writer to understand herself and her past.",
                "85%"
            )
        )
        tvShows.add(
            TvShowResponse(1,
                "Titans",
                "titans",
                "October 12, 2018",
                "A team of young superheroes led by Nightwing (formerly Batman s first Robin) form to combat evil and other perils.",
                "71%"
            )
        )

        return tvShows
    }
}