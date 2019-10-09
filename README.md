# How to test the app.

- Clean Architecture
- SOLID
- testing junit/espresso
- Room
- Kotlin


The app work* when you install it whatever genre you put, but is mocked only one call with http://www.mocky.io 
If you want to test it with all the possible genres, you need to have docker installed in your computer and run the docker .yml file.

1- DOCKER
  -If you have docker installed, you can run a server with the comand docker-compose up in the terminal and try the 
  search with all the genres (Adventure, Animation, Comedy, Crime, Documentary, Drama, Family, Fantasy, History, Horror,
  Music, Mystery, Romance, Science Fiction, Tv Movie, Thriller, War, Western). 
       
  You can find the docker-compose.yml file inside the project in a folder named "Server"
    1- Uncomment the code in this kotlin.class and comment the repeat code;
          - @xml/network_security_config
          - Api.kt
          - SearchImpl.kt
    2. Change your iPv4 (use terminal and type ipconfig), in order to do it work in the next documents:
          - @xml/network_security_config
          - Api.kt
  
* Could be possible that mocky.io it doesn't work, In this case you can generate a new valid call with this json and change the api call
in Api.kt(const val FILMS = "xxxxxxxxxxxx"):

{
    "data": [{
    		"id": 12,
			"title": "Finding Nemo",
			"tagline": "There are 3.7 trillion fish in the ocean. They're looking for one.",
			"overview": "Nemo, an adventurous young clownfish, is unexpectedly taken from his Great Barrier Reef home to a dentist's office aquarium. It's up to his worrisome father Marlin and a friendly but forgetful fish Dory to bring Nemo home -- meeting vegetarian sharks, surfer dude turtles, hypnotic jellyfish, hungry seagulls, and more along the way.",
			"popularity": 22.619522,
			"rating": 7.7,
			"ratingCount": 8422,
			"runtime": 100,
			"releaseDate": "2003-05-30",
			"revenue": 940335536,
			"budget": 94000000,
			"posterPath": "/syPWyeeqzTQIxjIUaIFI7d0TyEY.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 16,
				"name": "Animation"}, {
				"id": 10751,
				"name": "Family"}],
			"cast": [{
				"id": 13,
				"gender": 2,
				"name": "Albert Brooks",
				"character": "Marlin (voice)",
				"profilePath": "/kahlMTdygrPJ28VYRhKPavYD9hs.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/kahlMTdygrPJ28VYRhKPavYD9hs.jpg",
					"size": "w185"
				}}, {
				"id": 14,
				"gender": 1,
				"name": "Ellen DeGeneres",
				"character": "Dory (voice)",
				"profilePath": "/wBB6C4IGsYlHzIEMW6Q3JIvNAfz.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/wBB6C4IGsYlHzIEMW6Q3JIvNAfz.jpg",
					"size": "w185"
				}}, {
				"id": 12,
				"gender": 2,
				"name": "Alexander Gould",
				"character": "Nemo (voice)",
				"profilePath": "/c4EHOhxzwx7uDBxC8zODvKAEFGX.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/c4EHOhxzwx7uDBxC8zODvKAEFGX.jpg",
					"size": "w185"
				}}, {
				"id": 5293,
				"gender": 2,
				"name": "Willem Dafoe",
				"character": "Gill (voice)",
				"profilePath": "/7t8fhfaFBoS9VOo3OPXCfK516eI.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/7t8fhfaFBoS9VOo3OPXCfK516eI.jpg",
					"size": "w185"
				}}, {
				"id": 18,
				"gender": 2,
				"name": "Brad Garrett",
				"character": "Bloat (voice)",
				"profilePath": "/wXihtlnIvqP2oSNj33hiorDd3v9.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/wXihtlnIvqP2oSNj33hiorDd3v9.jpg",
					"size": "w185"
				}}, {
				"id": 19,
				"gender": 1,
				"name": "Allison Janney",
				"character": "Peach (voice)",
				"profilePath": "/hpBKWV1jjoXQbr1s0iUZTSvw582.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/hpBKWV1jjoXQbr1s0iUZTSvw582.jpg",
					"size": "w185"
				}}, {
				"id": 17401,
				"gender": 2,
				"name": "Stephen Root",
				"character": "Bubbles (voice)",
				"profilePath": "/sceCvLiv8xe2jQzrVn39wvosVHG.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/sceCvLiv8xe2jQzrVn39wvosVHG.jpg",
					"size": "w185"
				}}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/syPWyeeqzTQIxjIUaIFI7d0TyEY.jpg",
				"size": "w342"
			}}, 
{
			"id": 950,
			"title": "Ice Age: The Meltdown",
			"tagline": "The Ice age is melting away.",
			"overview": "Diego, Manny and Sid return in this sequel to the hit animated movie Ice Age. This time around, the deep freeze is over, and the ice-covered earth is starting to melt, which will destroy the trio's cherished valley. The impending disaster prompts them to reunite and warn all the other beasts about the desperate situation.",
			"popularity": 24.113135,
			"rating": 6.5,
			"ratingCount": 4144,
			"runtime": 91,
			"releaseDate": "2006-03-23",
			"revenue": 660940780,
			"budget": 80000000,
			"posterPath": "/isRuztu5Ch7FJdtSBLcG8QSOpEI.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 16,
				"name": "Animation"
			}, {
				"id": 10751,
				"name": "Family"
			}, {
				"id": 35,
				"name": "Comedy"
			}, {
				"id": 12,
				"name": "Adventure"
			}],
			"cast": [{
				"id": 15757,
				"gender": 2,
				"name": "Ray Romano",
				"character": "Manny (voice)",
				"profilePath": "/zWT03QvuVYySlrjmHCojKrNYjoC.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/zWT03QvuVYySlrjmHCojKrNYjoC.jpg",
					"size": "w185"
				}
			}, {
				"id": 5723,
				"gender": 2,
				"name": "John Leguizamo",
				"character": "Sid (voice)",
				"profilePath": "/rbq24AzthnwRXUYcVfUnP5bKN50.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/rbq24AzthnwRXUYcVfUnP5bKN50.jpg",
					"size": "w185"
				}
			}, {
				"id": 5724,
				"gender": 2,
				"name": "Denis Leary",
				"character": "Diego (voice)",
				"profilePath": "/lnk4HjUeqDlT6Kg9PaQsVIDpl56.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/lnk4HjUeqDlT6Kg9PaQsVIDpl56.jpg",
					"size": "w185"
				}
			}, {
				"id": 15758,
				"gender": 1,
				"name": "Queen Latifah",
				"character": "Ellie (voice)",
				"profilePath": "/ht52no1SMDhYBwRAmWL9a5YCss1.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/ht52no1SMDhYBwRAmWL9a5YCss1.jpg",
					"size": "w185"
				}
			}, {
				"id": 57599,
				"gender": 2,
				"name": "Seann William Scott",
				"character": "Crash (voice)",
				"profilePath": "/c7iqFLkgNiTMAS9xGw0GlfJcm4H.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/c7iqFLkgNiTMAS9xGw0GlfJcm4H.jpg",
					"size": "w185"
				}
			}, {
				"id": 15760,
				"gender": 2,
				"name": "Josh Peck",
				"character": "Eddie (voice)",
				"profilePath": "/MliTSjRnt2WMsFKQqEFLmOff8b.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/MliTSjRnt2WMsFKQqEFLmOff8b.jpg",
					"size": "w185"
				}
			}, {
				"id": 14991,
				"gender": 2,
				"name": "Jay Leno",
				"character": "Fast Tony (voice)",
				"profilePath": "/pmCpEGNkZnGxoKRVSMLHQnCtqAg.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/pmCpEGNkZnGxoKRVSMLHQnCtqAg.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/isRuztu5Ch7FJdtSBLcG8QSOpEI.jpg",
				"size": "w342"
			}
		}, {
			"id": 270946,
			"title": "Penguins of Madagascar",
			"tagline": "The Movie Event That Will Blow Their Cover",
			"overview": "Skipper, Kowalski, Rico and Private join forces with undercover organization The North Wind to stop the villainous Dr. Octavius Brine from destroying the world as we know it.",
			"popularity": 23.928473,
			"rating": 6.4,
			"ratingCount": 1706,
			"runtime": 92,
			"releaseDate": "2014-11-22",
			"revenue": 373552094,
			"budget": 132000000,
			"posterPath": "/pRer59eyY4rjkLPeKXKo7fPxCHH.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 10751,
				"name": "Family"
			}, {
				"id": 16,
				"name": "Animation"
			}, {
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 35,
				"name": "Comedy"
			}],
			"cast": [{
				"id": 18864,
				"gender": 2,
				"name": "Tom McGrath",
				"character": "Skipper (voice)",
				"profilePath": "/1qOQBwXSIAH0CKWP2RymCMdOi7a.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/1qOQBwXSIAH0CKWP2RymCMdOi7a.jpg",
					"size": "w185"
				}
			}, {
				"id": 12098,
				"gender": 2,
				"name": "Chris Miller",
				"character": "Kowalski (voice)",
				"profilePath": "/lw0PREJF51j1gPUQVO2tVX6dduJ.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/lw0PREJF51j1gPUQVO2tVX6dduJ.jpg",
					"size": "w185"
				}
			}, {
				"id": 12097,
				"gender": 2,
				"name": "Christopher Knights",
				"character": "Private (voice)",
				"profilePath": "/Ut3gyVRUhEn17gAJ4THnahs0fg.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/Ut3gyVRUhEn17gAJ4THnahs0fg.jpg",
					"size": "w185"
				}
			}, {
				"id": 12080,
				"gender": 2,
				"name": "Conrad Vernon",
				"character": "Rico (voice)",
				"profilePath": "/kSyVrs8NtLoQhfBXFBhnTWzC7Vm.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/kSyVrs8NtLoQhfBXFBhnTWzC7Vm.jpg",
					"size": "w185"
				}
			}, {
				"id": 6949,
				"gender": 2,
				"name": "John Malkovich",
				"character": "Dave (voice)",
				"profilePath": "/tCtiWZbKKRgHhLxFCIPfveYAsdc.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/tCtiWZbKKRgHhLxFCIPfveYAsdc.jpg",
					"size": "w185"
				}
			}, {
				"id": 71580,
				"gender": 2,
				"name": "Benedict Cumberbatch",
				"character": "Classified (voice)",
				"profilePath": "/wz3MRiMmoz6b5X3oSzMRC9nLxY1.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/wz3MRiMmoz6b5X3oSzMRC9nLxY1.jpg",
					"size": "w185"
				}
			}, {
				"id": 83586,
				"gender": 2,
				"name": "Ken Jeong",
				"character": "Short Fuse (voice)",
				"profilePath": "/rEebZHRju1WtSOdvQJB5je5ZNGj.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/rEebZHRju1WtSOdvQJB5je5ZNGj.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/pRer59eyY4rjkLPeKXKo7fPxCHH.jpg",
				"size": "w342"
			}
		}, {
			"id": 32657,
			"title": "Percy Jackson & the Olympians: The Lightning Thief",
			"tagline": "Worlds Collide",
			"overview": "Accident prone teenager, Percy discovers he's actually a demi-God, the son of Poseidon, and he is needed when Zeus' lightning is stolen. Percy must master his new found skills in order to prevent a war between the Gods that could devastate the entire world.",
			"popularity": 23.745026,
			"rating": 6,
			"ratingCount": 2831,
			"runtime": 118,
			"releaseDate": "2010-02-01",
			"revenue": 226497209,
			"budget": 95000000,
			"posterPath": "/5NhyXkodMzDRW8uqtPqlxJsoBhf.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 14,
				"name": "Fantasy"
			}, {
				"id": 10751,
				"name": "Family"
			}],
			"cast": [{
				"id": 33235,
				"gender": 2,
				"name": "Logan Lerman",
				"character": "Percy Jackson",
				"profilePath": "/A8Cws1ZLrUyHa2s8D2rsBeohgh3.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/A8Cws1ZLrUyHa2s8D2rsBeohgh3.jpg",
					"size": "w185"
				}
			}, {
				"id": 53336,
				"gender": 2,
				"name": "Brandon T. Jackson",
				"character": "Grover Underwood",
				"profilePath": "/dbToaM0GR8zxFFj2CmwDGCbfMXx.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/dbToaM0GR8zxFFj2CmwDGCbfMXx.jpg",
					"size": "w185"
				}
			}, {
				"id": 109513,
				"gender": 1,
				"name": "Alexandra Daddario",
				"character": "Annabeth Chase",
				"profilePath": "/s544zfrPI1Dnk60t1x1KUXF4iH3.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/s544zfrPI1Dnk60t1x1KUXF4iH3.jpg",
					"size": "w185"
				}
			}, {
				"id": 105727,
				"gender": 2,
				"name": "Jake Abel",
				"character": "Luke Castellan",
				"profilePath": "/b42lzZ38SHl4n1Oe2EHS9XNHdtO.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/b42lzZ38SHl4n1Oe2EHS9XNHdtO.jpg",
					"size": "w185"
				}
			}, {
				"id": 48,
				"gender": 2,
				"name": "Sean Bean",
				"character": "Zeus",
				"profilePath": "/iIxP2IzvcLgr5WaTBD4UfSqaV3q.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/iIxP2IzvcLgr5WaTBD4UfSqaV3q.jpg",
					"size": "w185"
				}
			}, {
				"id": 517,
				"gender": 2,
				"name": "Pierce Brosnan",
				"character": "Mr. Brunner / Chiron",
				"profilePath": "/1JXL0zrA26JjdoX8sqf57fJRDVM.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/1JXL0zrA26JjdoX8sqf57fJRDVM.jpg",
					"size": "w185"
				}
			}, {
				"id": 4581,
				"gender": 2,
				"name": "Steve Coogan",
				"character": "Hades",
				"profilePath": "/ljhsNmGQQrgeBj64x5uL27U6UqY.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/ljhsNmGQQrgeBj64x5uL27U6UqY.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/5NhyXkodMzDRW8uqtPqlxJsoBhf.jpg",
				"size": "w342"
			}
		}, {
			"id": 260514,
			"title": "Cars 3",
			"tagline": "It's not over until lightning strikes.",
			"overview": "Blindsided by a new generation of blazing-fast racers, the legendary Lightning McQueen is suddenly pushed out of the sport he loves. To get back in the game, he will need the help of an eager young race technician with her own plan to win, inspiration from the late Fabulous Hudson Hornet, and a few unexpected turns. Proving that #95 isn't through yet will test the heart of a champion on Piston Cup Racing’s biggest stage!",
			"popularity": 23.220418,
			"rating": 6.7,
			"ratingCount": 1588,
			"runtime": 109,
			"releaseDate": "2017-06-15",
			"revenue": 383925276,
			"budget": 175000000,
			"posterPath": "/fyy1nDC8wm553FCiBDojkJmKLCs.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 16,
				"name": "Animation"
			}, {
				"id": 35,
				"name": "Comedy"
			}, {
				"id": 10751,
				"name": "Family"
			}],
			"cast": [{
				"id": 887,
				"gender": 2,
				"name": "Owen Wilson",
				"character": "Lightning McQueen (voice)",
				"profilePath": "/j7oYgvfDiO34VcFdSB7GhM2CSle.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/j7oYgvfDiO34VcFdSB7GhM2CSle.jpg",
					"size": "w185"
				}
			}, {
				"id": 1374727,
				"gender": 1,
				"name": "Cristela Alonzo",
				"character": "Cruz Ramirez (voice)",
				"profilePath": "/6e3U7A40XH8nd7xva2gcR5YqOXg.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/6e3U7A40XH8nd7xva2gcR5YqOXg.jpg",
					"size": "w185"
				}
			}, {
				"id": 2955,
				"gender": 2,
				"name": "Chris Cooper",
				"character": "Smokey Yunick (voice)",
				"profilePath": "/ytZY7YofdiAZyiyr4NyiB77lwwQ.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/ytZY7YofdiAZyiyr4NyiB77lwwQ.jpg",
					"size": "w185"
				}
			}, {
				"id": 53807,
				"gender": 2,
				"name": "Armie Hammer",
				"character": "Jackson Storm (voice)",
				"profilePath": "/2zq984Jrw53AxDshTQPKpTPGLe8.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/2zq984Jrw53AxDshTQPKpTPGLe8.jpg",
					"size": "w185"
				}
			}, {
				"id": 5149,
				"gender": 1,
				"name": "Bonnie Hunt",
				"character": "Sally Careera (Voice)",
				"profilePath": "/uKAfrFRZYnHFAxw53Jldbs8yIZO.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/uKAfrFRZYnHFAxw53Jldbs8yIZO.jpg",
					"size": "w185"
				}
			}, {
				"id": 15897,
				"gender": 2,
				"name": "Larry the Cable Guy",
				"character": "Mater (Voice)",
				"profilePath": "/9yGwJBveIvLidqJEQI4PRuKQhMr.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/9yGwJBveIvLidqJEQI4PRuKQhMr.jpg",
					"size": "w185 "
				}
			}, {
				"id ": 51797,
				"gender ": 2,
				"name ": "Nathan Fillion ",
				"character ": "Sterling(voice)",
				"profilePath ": " / B7VTVtnKyFk0AtYjEbqzBQlPec.jpg ",
				"profileImage ": {
					"fullPath ": "https: //image.tmdb.org/t/p/w185/B7VTVtnKyFk0AtYjEbqzBQlPec.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/fyy1nDC8wm553FCiBDojkJmKLCs.jpg",
				"size": "w342"
			}
		}, {
			"id": 12445,
			"title": "Harry Potter and the Deathly Hallows: Part 2",
			"tagline": "It all ends here.",
			"overview": "Harry, Ron and Hermione continue their quest to vanquish the evil Voldemort once and for all. Just as things begin to look hopeless for the young wizards, Harry discovers a trio of magical objects that endow him with powers to rival Voldemort's formidable skills.",
			"popularity": 22.735934,
			"rating": 8,
			"ratingCount": 8262,
			"runtime": 130,
			"releaseDate": "2011-07-07",
			"revenue": 1342000000,
			"budget": 125000000,
			"posterPath": "/fTplI1NCSuEDP4ITLcTps739fcC.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 10751,
				"name": "Family"
			}, {
				"id": 14,
				"name": "Fantasy"
			}, {
				"id": 12,
				"name": "Adventure"
			}],
			"cast": [{
				"id": 10980,
				"gender": 2,
				"name": "Daniel Radcliffe",
				"character": "Harry Potter",
				"profilePath": "/kMSMa5tR43TLMR14ahU1neFVytz.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/kMSMa5tR43TLMR14ahU1neFVytz.jpg",
					"size": "w185"
				}
			}, {
				"id": 10989,
				"gender": 2,
				"name": "Rupert Grint",
				"character": "Ron Weasley",
				"profilePath": "/dFVVJufva2zUSP6WS0pFfR7g8uN.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/dFVVJufva2zUSP6WS0pFfR7g8uN.jpg",
					"size": "w185"
				}
			}, {
				"id": 10990,
				"gender": 1,
				"name": "Emma Watson",
				"character": "Hermione Granger",
				"profilePath": "/s77hUycSJ4x8RJWHDC9WPgotgxE.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/s77hUycSJ4x8RJWHDC9WPgotgxE.jpg",
					"size": "w185"
				}
			}, {
				"id": 4566,
				"gender": 2,
				"name": "Alan Rickman",
				"character": "Severus Snape",
				"profilePath": "/zOJgiaztnrnB7TSdGYU3uwpgivl.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/zOJgiaztnrnB7TSdGYU3uwpgivl.jpg",
					"size": "w185"
				}
			}, {
				"id": 10978,
				"gender": 1,
				"name": "Maggie Smith",
				"character": "Minerva McGonagall",
				"profilePath": "/kkMNu2iqkBPkbjhNBmDaUX7FHr.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/kkMNu2iqkBPkbjhNBmDaUX7FHr.jpg",
					"size": "w185"
				}
			}, {
				"id": 1283,
				"gender": 1,
				"name": "Helena Bonham Carter",
				"character": "Bellatrix Lestrange",
				"profilePath": "/rHZMwkumoRvhKV5ZvwBONKENAhG.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/rHZMwkumoRvhKV5ZvwBONKENAhG.jpg",
					"size": "w185"
				}
			}, {
				"id": 7056,
				"gender": 1,
				"name": "Emma Thompson",
				"character": "Sybill Trelawney",
				"profilePath": "/cWTBHN8kLf6yapxiaQD9C6N1uMw.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/cWTBHN8kLf6yapxiaQD9C6N1uMw.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/fTplI1NCSuEDP4ITLcTps739fcC.jpg",
				"size": "w342"
			}
		}, {
			"id": 150689,
			"title": "Cinderella",
			"tagline": "Midnight is just the beginning.",
			"overview": "When her father unexpectedly passes away, young Ella finds herself at the mercy of her cruel stepmother and her daughters. Never one to give up hope, Ella's fortunes begin to change after meeting a dashing stranger in the woods.",
			"popularity": 26.085409,
			"rating": 6.6,
			"ratingCount": 3268,
			"runtime": 105,
			"releaseDate": "2015-03-12",
			"revenue": 543514353,
			"budget": 95000000,
			"posterPath": "/o1F2aloaOUufHHOsV0laA9aw9N0.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 10749,
				"name": "Romance"
			}, {
				"id": 14,
				"name": "Fantasy"
			}, {
				"id": 10751,
				"name": "Family"
			}, {
				"id": 18,
				"name": "Drama"
			}],
			"cast": [{
					"id": 1016168,
					"gender": 1,
					"name": "Lily James",
					"character": "Cinderella",
					"profilePath": "/rfN0XMbIQLvgGvm4V8ZaTcFa1II.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/rfN0XMbIQLvgGvm4V8ZaTcFa1II.jpg",
						"size": "w185"
					}
				}, {
					"id": 112,
					"gender": 1,
					"name": "Cate Blanchett",
					"character": "Lady Tremaine",
					"profilePath": "/eE98pTm0Q2xIn0710VBC603IE5Q.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/eE98pTm0Q2xIn0710VBC603IE5Q.jpg",
						"size": "w185"
					}
				}, {
					"id": 512991,
					"gender": 2,
					"name": "Richard Madden",
					"character": "Prince Charming",
					"profilePath": "/4OBtiwJBBIeffW5XyY8u83ZPyoF.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/4OBtiwJBBIeffW5XyY8u83ZPyoF.jpg",
						"size": "w185"
					}
				},
				{
					"id": 1283,
					"gender": 1,
					"name": "Helena Bonham Carter",
					"character": "Fairy Godmother",
					"profilePath": "/rHZMwkumoRvhKV5ZvwBONKENAhG.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/rHZMwkumoRvhKV5ZvwBONKENAhG.jpg",
						"size": "w185"
					}
				},
				{
					"id": 937,
					"gender": 2,
					"name": "Derek Jacobi",
					"character": "The King",
					"profilePath": "/jJ4MkVS59gCfJhWMfLTbeHKjoyC.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/jJ4MkVS59gCfJhWMfLTbeHKjoyC.jpg",
						"size": "w185"
					}
				},
				{
					"id": 1640,
					"gender": 2,
					"name": "Stellan Skarsgård",
					"character": "Grand Duke",
					"profilePath": "/zSCU2agleLtJEvzj98jEesVhBxa.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/zSCU2agleLtJEvzj98jEesVhBxa.jpg",
						"size": "w185"
					}
				},
				{
					"id": 302165,
					"gender": 1,
					"name": "Holliday Grainger",
					"character": "Anastasia Tremaine",
					"profilePath": "/6hIz4Tu4TojIW5gITv1dw1cRSA3.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/6hIz4Tu4TojIW5gITv1dw1cRSA3.jpg",
						"size": "w185"
					}
				}
			],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/o1F2aloaOUufHHOsV0laA9aw9N0.jpg",
				"size": "w342"
			}
		},
		{
			"id": 20352,
			"title": "Despicable Me",
			"tagline": "Superbad. Superdad.",
			"overview": "Villainous Gru lives up to his reputation as a despicable, deplorable and downright unlikable guy when he hatches a plan to steal the moon from the sky. But he has a tough time staying on task after three orphans land in his care.",
			"popularity": 25.548149,
			"rating": 7.2,
			"ratingCount": 7997,
			"runtime": 95,
			"releaseDate": "2010-07-08",
			"revenue": 543513985,
			"budget": 69000000,
			"posterPath": "/4zHJhBSY4kNZXfhTlmy2TzXD51M.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 16,
				"name": "Animation"
			}, {
				"id": 10751,
				"name": "Family"
			}, {
				"id": 35,
				"name": "Comedy"
			}],
			"cast": [{
				"id": 4495,
				"gender": 2,
				"name": "Steve Carell",
				"character": "Gru (voice)",
				"profilePath": "/jHo6HUDgTL7j6wmipCzvjMGM0Dm.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/jHo6HUDgTL7j6wmipCzvjMGM0Dm.jpg",
					"size": "w185"
				}
			}, {
				"id": 41088,
				"gender": 2,
				"name": "Jason Segel",
				"character": "Vector (voice)",
				"profilePath": "/49zyYG6HSQm76mN1SLmCCzgIN0Y.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/49zyYG6HSQm76mN1SLmCCzgIN0Y.jpg",
					"size": "w185"
				}
			}, {
				"id": 59919,
				"gender": 2,
				"name": "Russell Brand",
				"character": "Dr. Nefario (voice)",
				"profilePath": "/WwyYUbZYq4YJ7Zh7KTy1klJNso.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/WwyYUbZYq4YJ7Zh7KTy1klJNso.jpg",
					"size": "w185"
				}
			}, {
				"id": 5823,
				"gender": 1,
				"name": "Julie Andrews",
				"character": "Gru's Mother (voice)",
				"profilePath": "/yQ0J92DMiLtQYoytLJ6CuBkdeN0.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/yQ0J92DMiLtQYoytLJ6CuBkdeN0.jpg",
					"size": "w185"
				}
			}, {
				"id": 21200,
				"gender": 2,
				"name": "Will Arnett",
				"character": "Mr. Perkins (voice)",
				"profilePath": "/vHCqn3SHfSV6GOWrxzEtoDaSMoU.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/vHCqn3SHfSV6GOWrxzEtoDaSMoU.jpg",
					"size": "w185"
				}
			}, {
				"id": 41091,
				"gender": 1,
				"name": "Kristen Wiig",
				"character": "Miss Hattie (voice)",
				"profilePath": "/iqRX3PDxA33zFhSfKTo5BE593G4.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/iqRX3PDxA33zFhSfKTo5BE593G4.jpg",
					"size": "w185"
				}
			}, {
				"id": 17743,
				"gender": 1,
				"name": "Miranda Cosgrove",
				"character": "Margo (voice)",
				"profilePath": "/i3Xnuc3ZOqtiwhwDgSf0t7WXz77.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/i3Xnuc3ZOqtiwhwDgSf0t7WXz77.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/4zHJhBSY4kNZXfhTlmy2TzXD51M.jpg",
				"size": "w342"
			}
		},{
			"id": 672,
			"title": "Harry Potter and the Chamber of Secrets",
			"tagline": "Hogwarts is back in session.",
			"overview": "Ignoring threats to his life, Harry returns to Hogwarts to investigate – aided by Ron and Hermione – a mysterious series of attacks.",
			"popularity": 25.115525,
			"rating": 7.5,
			"ratingCount": 8145,
			"runtime": 161,
			"releaseDate": "2002-11-13",
			"revenue": 876688482,
			"budget": 100000000,
			"posterPath": "/sdEOH0992YZ0QSxgXNIGLq1ToUi.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 14,
				"name": "Fantasy"
			}, {
				"id": 10751,
				"name": "Family"
			}],
			"cast": [{
				"id": 10980,
				"gender": 2,
				"name": "Daniel Radcliffe",
				"character": "Harry Potter",
				"profilePath": "/kMSMa5tR43TLMR14ahU1neFVytz.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/kMSMa5tR43TLMR14ahU1neFVytz.jpg",
					"size": "w185"
				}
			}, {
				"id": 10989,
				"gender": 2,
				"name": "Rupert Grint",
				"character": "Ron Weasley",
				"profilePath": "/dFVVJufva2zUSP6WS0pFfR7g8uN.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/dFVVJufva2zUSP6WS0pFfR7g8uN.jpg",
					"size": "w185"
				}
			}, {
				"id": 10990,
				"gender": 1,
				"name": "Emma Watson",
				"character": "Hermione Granger",
				"profilePath": "/s77hUycSJ4x8RJWHDC9WPgotgxE.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/s77hUycSJ4x8RJWHDC9WPgotgxE.jpg",
					"size": "w185"
				}
			}, {
				"id": 194,
				"gender": 2,
				"name": "Richard Harris",
				"character": "Albus Dumbledore",
				"profilePath": "/64jkJJtL5sins6nwGKOERduLSEA.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/64jkJJtL5sins6nwGKOERduLSEA.jpg",
					"size": "w185"
				}
			}, {
				"id": 4566,
				"gender": 2,
				"name": "Alan Rickman",
				"character": "Severus Snape",
				"profilePath": "/zOJgiaztnrnB7TSdGYU3uwpgivl.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/zOJgiaztnrnB7TSdGYU3uwpgivl.jpg",
					"size": "w185"
				}
			}, {
				"id": 10993,
				"gender": 2,
				"name": "Tom Felton",
				"character": "Draco Malfoy",
				"profilePath": "/1lzM9lcwuZynxX3WEfzJqAAxVag.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/1lzM9lcwuZynxX3WEfzJqAAxVag.jpg",
					"size": "w185"
				}
			}, {
				"id": 11181,
				"gender": 2,
				"name": "Kenneth Branagh",
				"character": "Gilderoy Lockhart ",
				"profilePath ": " / bmpGjbqvAVNOK3ggiuET2Jl96tZ.jpg ",
				"profileImage ": {
					"fullPath ": "https: //image.tmdb.org/t/p/w185/bmpGjbqvAVNOK3ggiuET2Jl96tZ.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/sdEOH0992YZ0QSxgXNIGLq1ToUi.jpg",
				"size": "w342"
			}
		}, {
			"id": 71805,
			"title": "Shipwrecked",
			"tagline": "",
			"overview": "A young Norwegian boy in 1850s England goes to work as a cabin boy and discovers some of his shipmates are actually pirates.",
			"popularity": 28.200869,
			"rating": 6.1,
			"ratingCount": 15,
			"runtime": 92,
			"releaseDate": "1990-10-03",
			"revenue": 0,
			"budget": 0,
			"posterPath": "/jf2PkR0Yt0ZRMKqtJzwja7JV2Hk.jpg",
			"originalLanguage": "no",
			"genres": [{
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 10751,
				"name": "Family"
			}],
			"cast": [{
				"id": 563838,
				"gender": 0,
				"name": "Stian Smestad",
				"character": "Haakon Haakonsen",
				"profilePath": null,
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185null",
					"size": "w185"
				}
			}, {
				"id": 5168,
				"gender": 2,
				"name": "Gabriel Byrne",
				"character": "Lt. John Merrick",
				"profilePath": "/lFIH4De52Eg21m7pScPMXezZDUh.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/lFIH4De52Eg21m7pScPMXezZDUh.jpg",
					"size": "w185"
				}
			}, {
				"id": 137748,
				"gender": 0,
				"name": "Louisa Milwood-Haigh",
				"character": "Mary",
				"profilePath": "/dyB9fdYCZLqPhB6PYUosIJBbrBE.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/dyB9fdYCZLqPhB6PYUosIJBbrBE.jpg",
					"size": "w185"
				}
			}, {
				"id": 71186,
				"gender": 2,
				"name": "Bjørn Sundquist",
				"character": "Mr. Håkonsen",
				"profilePath": "/4e4fDL75LqtIQXLtbkvc2oCx209.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/4e4fDL75LqtIQXLtbkvc2oCx209.jpg",
					"size": "w185"
				}
			}, {
				"id": 135121,
				"gender": 2,
				"name": "Joachim Rafaelsen",
				"character": "Ole",
				"profilePath": "/s5S2A0ZeDhwlSMAsdZK0izrUNES.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/s5S2A0ZeDhwlSMAsdZK0izrUNES.jpg",
					"size": "w185"
				}
			}, {
				"id": 174723,
				"gender": 2,
				"name": "William Ilkley",
				"character": "Pirate",
				"profilePath": null,
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185null",
					"size": "w185"
				}
			}, {
				"id": 1478933,
				"gender": 0,
				"name": "Trond Peter Stamsø Munch",
				"character": "Jens",
				"profilePath": null,
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185null",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/jf2PkR0Yt0ZRMKqtJzwja7JV2Hk.jpg",
				"size": "w342"
			}
		}, {
			"id": 109445,
			"title": "Frozen",
			"tagline": "Only the act of true love will thaw a frozen heart.",
			"overview": "Young princess Anna of Arendelle dreams about finding true love at her sister Elsa’s coronation. Fate takes her on a dangerous journey in an attempt to end the eternal winter that has fallen over the kingdom. She's accompanied by ice delivery man Kristoff, his reindeer Sven, and snowman Olaf. On an adventure where she will find out what friendship, courage, family, and true love really means.",
			"popularity": 27.215437,
			"rating": 7.3,
			"ratingCount": 7065,
			"runtime": 102,
			"releaseDate": "2013-11-27",
			"revenue": 1274219009,
			"budget": 150000000,
			"posterPath": "/jIjdFXKUNtdf1bwqMrhearpyjMj.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 16,
				"name": "Animation"
			}, {
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 10751,
				"name": "Family"
			}],
			"cast": [{
					"id": 40462,
					"gender": 1,
					"name": "Kristen Bell",
					"character": "Anna (voice)",
					"profilePath": "/9DoDVUkoXhT3O2R1RymPlOfUryl.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/9DoDVUkoXhT3O2R1RymPlOfUryl.jpg",
						"size": "w185"
					}
				}, {
					"id": 19394,
					"gender": 1,
					"name": "Idina Menzel",
					"character": "Elsa (voice)",
					"profilePath": "/h7xxQ7jVPBy5jjOsE89V3LSAkns.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/h7xxQ7jVPBy5jjOsE89V3LSAkns.jpg",
						"size": "w185"
					}
				}, {
					"id": 221611,
					"gender": 2,
					"name": "Jonathan Groff",
					"character": "Kristoff (voice)",
					"profilePath": "/xkFr1vd1pO2Ls2gQxxuMd1mgrfL.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/xkFr1vd1pO2Ls2gQxxuMd1mgrfL.jpg",
						"size": "w185"
					}
				}, {
					"id": 54415,
					"gender": 2,
					"name": "Josh Gad",
					"character": "Olaf (voice)",
					"profilePath": "/6ctni3kK4lPteBAInd7kKZyCdZD.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/6ctni3kK4lPteBAInd7kKZyCdZD.jpg",
						"size": "w185"
					}
				},
				{
					"id": 1188241,
					"gender": 2,
					"name": "Santino Fontana",
					"character": "Hans (voice)",
					"profilePath": "/unQZPxiKxJt5TkOBRO6Retppc4i.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/unQZPxiKxJt5TkOBRO6Retppc4i.jpg",
						"size": "w185"
					}
				},
				{
					"id": 21088,
					"gender": 2,
					"name": "Alan Tudyk",
					"character": "Duke (voice)",
					"profilePath": "/6QuMtbD8kmhpwWhFKfNzEvHRLOu.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/6QuMtbD8kmhpwWhFKfNzEvHRLOu.jpg",
						"size": "w185"
					}
				},
				{
					"id": 8785,
					"gender": 2,
					"name": "Ciarán Hinds",
					"character": "Pabbie / Grandpa (voice)",
					"profilePath": "/h5n8B12WoY1UAZjzSVEup4vsoBw.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/h5n8B12WoY1UAZjzSVEup4vsoBw.jpg",
						"size": "w185"
					}
				}
			],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/jIjdFXKUNtdf1bwqMrhearpyjMj.jpg",
				"size": "w342"
			}
		},
		{
			"id": 364689,
			"title": "Ferdinand",
			"tagline": "Built To Fight. Born To Love",
			"overview": "Ferdinand, a little bull, prefers sitting quietly under a cork tree just smelling the flowers versus jumping around, snorting, and butting heads with other bulls. As Ferdinand grows big and strong, his temperament remains mellow, but one day five men come to choose the \"biggest, fastest, roughest bull\" for the bullfights in Madrid and Ferdinand is mistakenly chosen.  Based on the classic 1936 children's book by Munro Leaf.",
			"popularity": 32.246726,
			"rating": 6.9,
			"ratingCount": 680,
			"runtime": 107,
			"releaseDate": "2017-12-09",
			"revenue": 294764262,
			"budget": 111000000,
			"posterPath": "/rMm94JsRfcOPiPVsTRcBiiVBOhz.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 16,
				"name": "Animation"
			}, {
				"id": 35,
				"name": "Comedy"
			}, {
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 10751,
				"name": "Family"
			}],
			"cast": [{
				"id": 56446,
				"gender": 2,
				"name": "John Cena",
				"character": "Ferdinand (voice)",
				"profilePath": "/WbnZd6SK3DRlQBBW1yP1xHwlbs.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/WbnZd6SK3DRlQBBW1yP1xHwlbs.jpg",
					"size": "w185"
				}
			}, {
				"id": 1240487,
				"gender": 1,
				"name": "Kate McKinnon",
				"character": "Lupe (voice)",
				"profilePath": "/jzgiKHmkhxhvELnq9ccDkFc8Ynn.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/jzgiKHmkhxhvELnq9ccDkFc8Ynn.jpg",
					"size": "w185"
				}
			}, {
				"id": 18471,
				"gender": 2,
				"name": "Anthony Anderson",
				"character": "Bones (voice)",
				"profilePath": "/xcMJimUAcQJGCSw25je1TLMy8rC.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/xcMJimUAcQJGCSw25je1TLMy8rC.jpg",
					"size": "w185"
				}
			}, {
				"id": 21127,
				"gender": 2,
				"name": "Bobby Cannavale",
				"character": "Valiente / Valiente's Father (voice)",
				"profilePath": "/o3xnmePoOUCw7sjoZ4xM4W5DL26.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/o3xnmePoOUCw7sjoZ4xM4W5DL26.jpg",
					"size": "w185"
				}
			}, {
				"id": 20049,
				"gender": 2,
				"name": "David Tennant",
				"character": "Angus (voice)",
				"profilePath": "/dvhgfeZtK0aSHU1H8rkGwFTq28b.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/dvhgfeZtK0aSHU1H8rkGwFTq28b.jpg",
					"size": "w185"
				}
			}, {
				"id": 1217825,
				"gender": 2,
				"name": "Peyton Manning",
				"character": "Guapo (voice)",
				"profilePath": "/k3AE7sFccHCrGUkTsnnyB9Kz8u0.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/k3AE7sFccHCrGUkTsnnyB9Kz8u0.jpg",
					"size": "w185"
				}
			}, {
				"id": 180486,
				"gender": 1,
				"name": "Gina Rodriguez",
				"character": "Una (voice)",
				"profilePath": "/s1m3BmHGRaWQN5QJyZHHgdjqCQP.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/s1m3BmHGRaWQN5QJyZHHgdjqCQP.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/rMm94JsRfcOPiPVsTRcBiiVBOhz.jpg",
				"size": "w342"
			}
		}, {
			"id": 177572,
			"title": "Big Hero 6",
			"tagline": "",
			"overview": "The special bond that develops between plus-sized inflatable robot Baymax, and prodigy Hiro Hamada, who team up with a group of friends to form a band of high-tech heroes.",
			"popularity": 29.883612,
			"rating": 7.7,
			"ratingCount": 7975,
			"runtime": 102,
			"releaseDate": "2014-10-24",
			"revenue": 657818612,
			"budget": 165000000,
			"posterPath": "/9gLu47Zw5ertuFTZaxXOvNfy78T.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 10751,
				"name": "Family"
			}, {
				"id": 16,
				"name": "Animation"
			}, {
				"id": 28,
				"name": "Action"
			}, {
				"id": 35,
				"name": "Comedy"
			}],
			"cast": [{
				"id": 66580,
				"gender": 2,
				"name": "Scott Adsit",
				"character": "Baymax (voice)",
				"profilePath": "/jp9FubdwhkovfMi2xBN1uUUiGGz.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/jp9FubdwhkovfMi2xBN1uUUiGGz.jpg",
					"size": "w185"
				}
			}, {
				"id": 515510,
				"gender": 2,
				"name": "Ryan Potter",
				"character": "Hiro Hamada (voice)",
				"profilePath": "/3Hdip1zNYrea3V7uzJQYxTps5Ne.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/3Hdip1zNYrea3V7uzJQYxTps5Ne.jpg",
					"size": "w185"
				}
			}, {
				"id": 82093,
				"gender": 2,
				"name": "Daniel Henney",
				"character": "Tadashi Hamada (voice)",
				"profilePath": "/wwLWCVSP9la3dG6xQBqUd1YzwMh.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/wwLWCVSP9la3dG6xQBqUd1YzwMh.jpg",
					"size": "w185"
				}
			}, {
				"id": 51990,
				"gender": 2,
				"name": "T.J. Miller",
				"character": "Fred (voice)",
				"profilePath": "/wkm8YvulYwuB4pxEvOAlwv8AWdr.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/wkm8YvulYwuB4pxEvOAlwv8AWdr.jpg",
					"size": "w185"
				}
			}, {
				"id": 78324,
				"gender": 1,
				"name": "Jamie Chung",
				"character": "GoGo Tomago (voice)",
				"profilePath": "/99vO72TfiweEMShZUL9lE7oOhYw.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/99vO72TfiweEMShZUL9lE7oOhYw.jpg",
					"size": "w185"
				}
			}, {
				"id": 87822,
				"gender": 2,
				"name": "Damon Wayans Jr.",
				"character": "Wasabi (voice)",
				"profilePath": "/wOYJdq19v0rnUTY9vC0BZJowQiC.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/wOYJdq19v0rnUTY9vC0BZJowQiC.jpg",
					"size": "w185"
				}
			}, {
				"id": 589162,
				"gender": 1,
				"name": "Génesis Rodríguez ",
				"character ": "Honey Lemon(voice)",
				"profilePath ": " / vxpfF5QZWny1PflPXNePe5am4RI.jpg ",
				"profileImage ": {
					"fullPath ": "https: //image.tmdb.org/t/p/w185/vxpfF5QZWny1PflPXNePe5am4RI.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/9gLu47Zw5ertuFTZaxXOvNfy78T.jpg",
				"size": "w342"
			}
		}, {
			"id": 57800,
			"title": "Ice Age: Continental Drift",
			"tagline": "Manny, Diego, and Sid embark upon another adventure after their continent is set adrift.",
			"overview": "Manny, Diego, and Sid embark upon another adventure after their continent is set adrift. Using an iceberg as a ship, they encounter sea creatures and battle pirates as they explore a new world.",
			"popularity": 29.691214,
			"rating": 6.2,
			"ratingCount": 3451,
			"runtime": 88,
			"releaseDate": "2012-06-26",
			"revenue": 877244782,
			"budget": 95000000,
			"posterPath": "/u30xsZd3mijrdBKA6CeDsozx48g.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 16,
				"name": "Animation"
			}, {
				"id": 35,
				"name": "Comedy"
			}, {
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 10751,
				"name": "Family"
			}],
			"cast": [{
				"id": 5723,
				"gender": 2,
				"name": "John Leguizamo",
				"character": "Sid (voice)",
				"profilePath": "/rbq24AzthnwRXUYcVfUnP5bKN50.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/rbq24AzthnwRXUYcVfUnP5bKN50.jpg",
					"size": "w185"
				}
			}, {
				"id": 15757,
				"gender": 2,
				"name": "Ray Romano",
				"character": "Manny (voice)",
				"profilePath": "/zWT03QvuVYySlrjmHCojKrNYjoC.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/zWT03QvuVYySlrjmHCojKrNYjoC.jpg",
					"size": "w185"
				}
			}, {
				"id": 5713,
				"gender": 2,
				"name": "Chris Wedge",
				"character": "Scrat (voice)",
				"profilePath": "/iFT7oH4LdkByqwPgAs2XfNVJCXO.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/iFT7oH4LdkByqwPgAs2XfNVJCXO.jpg",
					"size": "w185"
				}
			}, {
				"id": 5724,
				"gender": 2,
				"name": "Denis Leary",
				"character": "Diego (voice)",
				"profilePath": "/lnk4HjUeqDlT6Kg9PaQsVIDpl56.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/lnk4HjUeqDlT6Kg9PaQsVIDpl56.jpg",
					"size": "w185"
				}
			}, {
				"id": 57599,
				"gender": 2,
				"name": "Seann William Scott",
				"character": "Crash (voice)",
				"profilePath": "/c7iqFLkgNiTMAS9xGw0GlfJcm4H.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/c7iqFLkgNiTMAS9xGw0GlfJcm4H.jpg",
					"size": "w185"
				}
			}, {
				"id": 16866,
				"gender": 1,
				"name": "Jennifer Lopez",
				"character": "Shira (voice)",
				"profilePath": "/yOz9MwgY9IV4kV9QdJyMCrATHCw.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/yOz9MwgY9IV4kV9QdJyMCrATHCw.jpg",
					"size": "w185"
				}
			}, {
				"id": 15758,
				"gender": 1,
				"name": "Queen Latifah",
				"character": "Ellie (voice)",
				"profilePath": "/ht52no1SMDhYBwRAmWL9a5YCss1.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/ht52no1SMDhYBwRAmWL9a5YCss1.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/u30xsZd3mijrdBKA6CeDsozx48g.jpg",
				"size": "w342"
			}
		}, {
			"id": 259316,
			"title": "Fantastic Beasts and Where to Find Them",
			"tagline": "From J.K. Rowling's wizarding world.",
			"overview": "In 1926, Newt Scamander arrives at the Magical Congress of the United States of America with a magically expanded briefcase, which houses a number of dangerous creatures and their habitats. When the creatures escape from the briefcase, it sends the American wizarding authorities after Newt, and threatens to strain even further the state of magical and non-magical relations.",
			"popularity": 29.355201,
			"rating": 7.3,
			"ratingCount": 8139,
			"runtime": 133,
			"releaseDate": "2016-11-16",
			"revenue": 809342332,
			"budget": 180000000,
			"posterPath": "/1M91Bt3oGspda75H9eLqYZkJzgO.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 10751,
				"name": "Family"
			}, {
				"id": 14,
				"name": "Fantasy"
			}],
			"cast": [{
					"id": 37632,
					"gender": 2,
					"name": "Eddie Redmayne",
					"character": "Newt Scamander",
					"profilePath": "/bHipa1GkpedD32w2OIRg5axdkQ6.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/bHipa1GkpedD32w2OIRg5axdkQ6.jpg",
						"size": "w185"
					}
				}, {
					"id": 72466,
					"gender": 2,
					"name": "Colin Farrell",
					"character": "Percival Graves",
					"profilePath": "/pgMM9r5ll99RXSmz1J4sj8zaddW.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/pgMM9r5ll99RXSmz1J4sj8zaddW.jpg",
						"size": "w185"
					}
				},
				{
					"id": 77795,
					"gender": 1,
					"name": "Katherine Waterston",
					"character": "Porpentina \"Tina\" Goldstein",
					"profilePath": "/zgLVX4KJJ6hTD2niGLchkzjfWpJ.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/zgLVX4KJJ6hTD2niGLchkzjfWpJ.jpg",
						"size": "w185"
					}
				},
				{
					"id": 58873,
					"gender": 2,
					"name": "Dan Fogler",
					"character": "Jacob Kowalski",
					"profilePath": "/75hCIe6KHpHUlJDcyoxEp035BWz.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/75hCIe6KHpHUlJDcyoxEp035BWz.jpg",
						"size": "w185"
					}
				},
				{
					"id": 998225,
					"gender": 1,
					"name": "Alison Sudol",
					"character": "Queenie Goldstein",
					"profilePath": "/w0ixLYjKN5I171bQ3XSsgW3Lte3.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/w0ixLYjKN5I171bQ3XSsgW3Lte3.jpg",
						"size": "w185"
					}
				},
				{
					"id": 10127,
					"gender": 2,
					"name": "Jon Voight",
					"character": "Henry Shaw Sr",
					"profilePath": "/c7BvyqlvqDkfkFqSBUCiR21fvTh.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/c7BvyqlvqDkfkFqSBUCiR21fvTh.jpg",
						"size": "w185"
					}
				},
				{
					"id": 2372,
					"gender": 2,
					"name": "Ron Perlman",
					"character": "Gnarlack",
					"profilePath": "/xZyrXT2iEmSOokQRc1hedmxrbTi.jpg",
					"profileImage": {
						"fullPath": "https://image.tmdb.org/t/p/w185/xZyrXT2iEmSOokQRc1hedmxrbTi.jpg",
						"size": "w185"
					}
				}
			],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/1M91Bt3oGspda75H9eLqYZkJzgO.jpg",
				"size": "w342"
			}
		}, {
			"id": 278154,
			"title": "Ice Age: Collision Course",
			"tagline": "One small step. One giant mess.",
			"overview": "Set after the events of Continental Drift, Scrat's epic pursuit of his elusive acorn catapults him outside of Earth, where he accidentally sets off a series of cosmic events that transform and threaten the planet. To save themselves from peril, Manny, Sid, Diego, and the rest of the herd leave their home and embark on a quest full of thrills and spills, highs and lows, laughter and adventure while traveling to exotic new lands and encountering a host of colorful new characters.",
			"popularity": 39.536288,
			"rating": 5.7,
			"ratingCount": 1628,
			"runtime": 100,
			"releaseDate": "2016-06-23",
			"revenue": 408579038,
			"budget": 105000000,
			"posterPath": "/gRi7lTBBiRBhn9aJID5MdldcJEJ.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 12,
				"name": "Adventure"
			}, {
				"id": 16,
				"name": "Animation"
			}, {
				"id": 10751,
				"name": "Family"
			}, {
				"id": 35,
				"name": "Comedy"
			}],
			"cast": [{
				"id": 15757,
				"gender": 2,
				"name": "Ray Romano",
				"character": "Manny (voice)",
				"profilePath": "/zWT03QvuVYySlrjmHCojKrNYjoC.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/zWT03QvuVYySlrjmHCojKrNYjoC.jpg",
					"size": "w185"
				}
			}, {
				"id": 5723,
				"gender": 2,
				"name": "John Leguizamo",
				"character": "Sid (voice)",
				"profilePath": "/rbq24AzthnwRXUYcVfUnP5bKN50.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/rbq24AzthnwRXUYcVfUnP5bKN50.jpg",
					"size": "w185"
				}
			}, {
				"id": 5724,
				"gender": 2,
				"name": "Denis Leary",
				"character": "Diego (voice)",
				"profilePath": "/lnk4HjUeqDlT6Kg9PaQsVIDpl56.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/lnk4HjUeqDlT6Kg9PaQsVIDpl56.jpg",
					"size": "w185"
				}
			}, {
				"id": 15758,
				"gender": 1,
				"name": "Queen Latifah",
				"character": "Ellie (voice)",
				"profilePath": "/ht52no1SMDhYBwRAmWL9a5YCss1.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/ht52no1SMDhYBwRAmWL9a5YCss1.jpg",
					"size": "w185"
				}
			}, {
				"id": 57599,
				"gender": 2,
				"name": "Seann William Scott",
				"character": "Crash (voice)",
				"profilePath": "/c7iqFLkgNiTMAS9xGw0GlfJcm4H.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/c7iqFLkgNiTMAS9xGw0GlfJcm4H.jpg",
					"size": "w185"
				}
			}, {
				"id": 15760,
				"gender": 2,
				"name": "Josh Peck",
				"character": "Eddie",
				"profilePath": "/MliTSjRnt2WMsFKQqEFLmOff8b.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/MliTSjRnt2WMsFKQqEFLmOff8b.jpg",
					"size": "w185"
				}
			}, {
				"id": 11108,
				"gender": 2,
				"name": "Simon Pegg",
				"character": "Buck (voice)",
				"profilePath": "/23e2uoNlpDvLumNic16fS2YjZjL.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/23e2uoNlpDvLumNic16fS2YjZjL.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/gRi7lTBBiRBhn9aJID5MdldcJEJ.jpg",
				"size": "w342"
			}
		}, {
			"id": 406997,
			"title": "Wonder",
			"tagline": "Are you ready to meet Auggie Pullman?",
			"overview": "The story of August Pullman – a boy with facial differences – who enters fifth grade, attending a mainstream elementary school for the first time.",
			"popularity": 36.500685,
			"rating": 8.2,
			"ratingCount": 1927,
			"runtime": 113,
			"releaseDate": "2017-11-13",
			"revenue": 300503113,
			"budget": 20000000,
			"posterPath": "/ouYgAatYH4JzIThj6FI3UYf31RI.jpg",
			"originalLanguage": "en",
			"genres": [{
				"id": 18,
				"name": "Drama"
			}, {
				"id": 10751,
				"name": "Family"
			}],
			"cast": [{
				"id": 1277188,
				"gender": 2,
				"name": "Jacob Tremblay",
				"character": "August 'Auggie ' Pullman",
				"profilePath": "/7ePQeYnYbTSOAVxPNEN166Rr3GI.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/7ePQeYnYbTSOAVxPNEN166Rr3GI.jpg",
					"size": "w185"
				}
			}, {
				"id": 1204,
				"gender": 1,
				"name": "Julia Roberts",
				"character": "Isabel Pullman",
				"profilePath": "/h13yvG0tRNMTAwciQXxYmQWdYW8.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/h13yvG0tRNMTAwciQXxYmQWdYW8.jpg",
					"size": "w185"
				}
			}, {
				"id": 887,
				"gender": 2,
				"name": "Owen Wilson",
				"character": "Nate Pullman",
				"profilePath": "/j7oYgvfDiO34VcFdSB7GhM2CSle.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/j7oYgvfDiO34VcFdSB7GhM2CSle.jpg",
					"size": "w185"
				}
			}, {
				"id": 1109976,
				"gender": 1,
				"name": "Izabela Vidovic",
				"character": "Olivia 'Via ' Pullman",
				"profilePath": "/q8lxW2OaUmP5OF8SkntIp2vPcDX.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/q8lxW2OaUmP5OF8SkntIp2vPcDX.jpg",
					"size": "w185"
				}
			}, {
				"id": 25503,
				"gender": 2,
				"name": "Mandy Patinkin",
				"character": "Lawrence Tushman ",
				"profilePath ": " / 4 yUgIErXR9G70fj6V38YVfzJ4Tv.jpg ",
				"profileImage ": {
					"fullPath ": "https: //image.tmdb.org/t/p/w185/4yUgIErXR9G70fj6V38YVfzJ4Tv.jpg",
					"size": "w185"
				}
			}, {
				"id": 1652371,
				"gender": 2,
				"name": "Daveed Diggs",
				"character": "Thomas Browne",
				"profilePath": "/1LLtCpfMOsumo42iIzr1djkesGM.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/1LLtCpfMOsumo42iIzr1djkesGM.jpg",
					"size": "w185"
				}
			}, {
				"id": 1590759,
				"gender": 2,
				"name": "Noah Jupe",
				"character": "Jack Will",
				"profilePath": "/nlYNme15ON67ofOuHMDnW3Zl42K.jpg",
				"profileImage": {
					"fullPath": "https://image.tmdb.org/t/p/w185/nlYNme15ON67ofOuHMDnW3Zl42K.jpg",
					"size": "w185"
				}
			}],
			"poster": {
				"fullPath": "https://image.tmdb.org/t/p/w342/ouYgAatYH4JzIThj6FI3UYf31RI.jpg",
				"size": "w342"
			}
		}
	]
}
  
