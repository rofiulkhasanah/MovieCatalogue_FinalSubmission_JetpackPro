package com.dicoding.moviecatalogue.utils

import com.dicoding.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.TvShowEntity
import com.dicoding.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.moviecatalogue.data.source.remote.response.TvShowResponse

object DataTMDB {
    fun generateMovies(): ArrayList<MovieEntity> {
        val movie = ArrayList<MovieEntity>()
        movie.add(
            MovieEntity(
                "399566",
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "8.3"
            )
        )

        movie.add(
            MovieEntity(
                "791373",
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "2021-03-18",
                "8.5"
            )
        )

        movie.add(
            MovieEntity(
                "460465",
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "/8yhtzsbBExY8mUct2GOk4LDDuGH.jpg",
                "2021-04-07",
                "7.3"
            )
        )

        movie.add(
            MovieEntity(
                "615678",
                "Thunder Force",
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                "/279yOM4OQREL36B3SECnRxoB4MZ.jpg",
                "2021-04-09",
                "5.9"
            )
        )

        movie.add(
            MovieEntity(
                "412656",
                "Chaos Walking",
                "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                "2021-02-24",
                "7.4"
            )
        )

        movie.add(
            MovieEntity(
                "527774",
                "Raya and the Last Dragon",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "2021-03-03",
                "8.3"
            )
        )

        movie.add(
            MovieEntity(
                "664767",
                "Mortal Kombat Legends: Scorpion's Revenge",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
                "2020-04-12",
                "8.4"
            )
        )

        movie.add(
            MovieEntity(
                "458576",
                "Monster Hunter",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "2020-12-03",
                "7.1"
            )
        )

        movie.add(
            MovieEntity(
                "793723",
                "Sentinelle",
                "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                "/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg",
                "2021-03-05",
                "6.1"
            )
        )

        movie.add(
            MovieEntity(
                "644083",
                "Twist",
                "A Dicken’s classic brought thrillingly up to date in the teeming heartland of modern London, where a group of street smart young hustlers plan the heist of the century for the ultimate payday.",
                "/29dCusd9PwHrbDqzxNG35WcpZpS.jpg",
                "2021-01-22",
                "7"

            )
        )
        return movie
    }

    fun generateTvShow(): ArrayList<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                "88396",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "7.9"
            )
        )

        tvShow.add(
            TvShowEntity(
                "71712",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "8.6"
            )
        )

        tvShow.add(
            TvShowEntity(
                "60735",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "7.7"
            )
        )

        tvShow.add(
            TvShowEntity(
                "95557",
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "8.9"
            )
        )

        tvShow.add(
            TvShowEntity(
                "69050",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "8.6"
            )
        )

        tvShow.add(
            TvShowEntity(
                "63174",
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "8.5"
            )
        )

        tvShow.add(
            TvShowEntity(
                "85271",
                "WandaVision",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "8.4"
            )
        )

        tvShow.add(
            TvShowEntity(
                "1402",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                "8.1"
            )
        )

        tvShow.add(
            TvShowEntity(
                "120168",
                "Who Killed Sara?",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                "7.8"
            )
        )

        tvShow.add(
            TvShowEntity(
                "95057",
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                "/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg",
                "8.3"
            )
        )
        return tvShow
    }

    fun generateRemoteDummyMovies(): ArrayList<MovieResponse> {
        val movie = ArrayList<MovieResponse>()
        movie.add(
            MovieResponse(
                399566,
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                8.3
            )
        )
        movie.add(
            MovieResponse(
                791373,
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "2021-03-18",
                8.5
            )
        )

        movie.add(
            MovieResponse(
                460465,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "/8yhtzsbBExY8mUct2GOk4LDDuGH.jpg",
                "2021-04-07",
                7.3
            )
        )

        movie.add(
            MovieResponse(
                615678,
                "Thunder Force",
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                "/279yOM4OQREL36B3SECnRxoB4MZ.jpg",
                "2021-04-09",
                5.9
            )
        )

        movie.add(
            MovieResponse(
                412656,
                "Chaos Walking",
                "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                "2021-02-24",
                7.4
            )
        )

        movie.add(
            MovieResponse(
                527774,
                "Raya and the Last Dragon",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "2021-03-03",
                8.3
            )
        )

        movie.add(
            MovieResponse(
                664767,
                "Mortal Kombat Legends: Scorpion's Revenge",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
                "2020-04-12",
                8.4
            )
        )

        movie.add(
            MovieResponse(
                458576,
                "Monster Hunter",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "2020-12-03",
                7.1
            )
        )

        movie.add(
            MovieResponse(
                793723,
                "Sentinelle",
                "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                "/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg",
                "2021-03-05",
                6.1
            )
        )

        movie.add(
            MovieResponse(
                644083,
                "Twist",
                "A Dicken’s classic brought thrillingly up to date in the teeming heartland of modern London, where a group of street smart young hustlers plan the heist of the century for the ultimate payday.",
                "/29dCusd9PwHrbDqzxNG35WcpZpS.jpg",
                "2021-01-22",
                7.0
            )
        )
        return movie
    }

    fun generateRemoteDummyTvShow(): ArrayList<TvShowResponse> {
        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(
            TvShowResponse(
                88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9
            )
        )

        tvShow.add(
            TvShowResponse(
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                8.6
            )
        )

        tvShow.add(
            TvShowResponse(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7.7
            )
        )

        tvShow.add(
            TvShowResponse(
                95557,
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                8.9
            )
        )

        tvShow.add(
            TvShowResponse(
                69050,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                8.6
            )
        )

        tvShow.add(
            TvShowResponse(
                63174,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                8.5
            )
        )

        tvShow.add(
            TvShowResponse(
                85271,
                "WandaVision",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                8.4
            )
        )

        tvShow.add(
            TvShowResponse(
                1402,
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                8.1
            )
        )

        tvShow.add(
            TvShowResponse(
                120168,
                "Who Killed Sara?",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                7.8
            )
        )

        tvShow.add(
            TvShowResponse(
                95057,
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                "/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg",
                8.3
            )
        )
        return tvShow
    }


}
