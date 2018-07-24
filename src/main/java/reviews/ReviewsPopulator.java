package reviews;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewsPopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		Tag hot = tagRepo.save(new Tag("Hot"));
		Tag pyramids = tagRepo.save(new Tag("Pyramids"));
		Tag nile = tagRepo.save(new Tag("Nile"));
		Tag ancient = tagRepo.save(new Tag("Ancient"));
		Tag mediterranean = tagRepo.save(new Tag("Mediterranean"));
		Tag marketplace = tagRepo.save(new Tag("Marketplace"));
		Tag serengeti = tagRepo.save(new Tag("Serengeti"));
		Tag safari = tagRepo.save(new Tag("safari"));
		Tag china = tagRepo.save(new Tag("China"));
		Tag beach = tagRepo.save(new Tag("Beach"));
		Tag scuba = tagRepo.save(new Tag("Scuba"));
		Tag island = tagRepo.save(new Tag("Island"));
		Tag skyscraper = tagRepo.save(new Tag("Skyscraper"));
		Tag shopping = tagRepo.save(new Tag("Shopping"));
		Tag tropics= tagRepo.save(new Tag("Tropics"));
		Tag fish = tagRepo.save(new Tag("Fish"));
		Tag harbour = tagRepo.save(new Tag("Harbour"));
		Tag gardens = tagRepo.save(new Tag("Gardens"));
		Tag arts = tagRepo.save(new Tag("Arts"));
		Tag architecture = tagRepo.save(new Tag("Architecture"));
		Tag gastronomy = tagRepo.save(new Tag("Gastronomy"));
		Tag culture = tagRepo.save(new Tag("Culture"));
		Tag wildlife = tagRepo.save(new Tag("Wildlife"));
		Tag mountains = tagRepo.save(new Tag("Mountains"));
		Tag forest = tagRepo.save(new Tag("Forests"));
		Tag prairie = tagRepo.save(new Tag("Prairie"));
		
		Category asia = categoryRepo.save(new Category("Asia"));
		Category northAmerica = categoryRepo.save(new Category("North America"));
		Category southAmerica = categoryRepo.save(new Category("South America"));
		Category europe = categoryRepo.save(new Category("Europe"));
		Category africa = categoryRepo.save(new Category("Africa"));
		Category australia = categoryRepo.save(new Category("Australia"));

		Review morocco = reviewRepo.save(new Review("Morocco",
				"Walking through the various souks of the labyrinthine medina, you will find sights,"
						+ " smells and tastes, you could only dream of. While Morocco is not easy traveling,"
						+ " it gets rave reviews from those who venture there",
				"/images/morocco.jpeg", africa, hot, mediterranean, marketplace, culture));
		Review egypt = reviewRepo
				.save(new Review("Egypt", "If you have always wanted to see the pyramids in Egypt, then "
						+ "make Giza your next travel destination.", "/images/egypt.jpeg", africa, hot, ancient, nile, pyramids));
		Review tanzania = reviewRepo.save(new Review("Tanzania", "In Northeast Tanzania is the Serengeti National "
				+ "Park, one of Africa’s most incredible conservation areas.", "/images/tanzania.jpeg", africa, hot, serengeti, safari));
		Review sanya = reviewRepo
				.save(new Review("Sanya", "The Hawaii of China. Sunny, tranquil stretch of South China Sea. "
						+ "A haven for beach lovers and foodies", "/images/sanya.jpg", asia, china, beach, scuba, island));
		Review dubai = reviewRepo.save(new Review("Dubai",
				"Amazing city, bursting with life, super expensive but with multitudes of things to do.", "/images/dubai.jpeg",
				asia, hot, beach, scuba, marketplace, shopping, skyscraper));
		Review hongKong = reviewRepo.save(new Review("Hong Kong",
				"An easy introduction to China. Towering skyscrapers, numerous "
						+ "street markets and thousands of dining options. For unmatched natural beauty, head to Hong Kong's outlying islands.",
				"/images/hongkong.jpeg", asia, marketplace, china, skyscraper, shopping));
		Review maldives = reviewRepo.save(new Review("Maldives",
				"This far-flung destination, miles from civilization in the Indian "
						+ "Ocean, is made up of about 1,200 islands, many of which offer unparalleled white sand beaches, crystal clear waters and coral reefs that prompt extensive exploration. ",
				"/images/maldives.jpeg", asia, island, tropics, fish, beach, scuba));

		Review sydney = reviewRepo.save(new Review("Sydney",
				"Australia's newly renovated landmark, the Sydney Opera House, "
						+ "showcasing new machinery, lighting and improved acoustics, makes Sydney an amazing spot.",
				"/images/sydney.jpeg", australia, harbour, gardens, arts, architecture));
		Review melbourne = reviewRepo.save(new Review("Melbourne", "The coastal capital of the southeastern Australian "
				+ "state of Victoria. Explore native art, history and culture.", "/images/melbourne.jpeg", australia, arts, architecture));
		Review cairns = reviewRepo.save(new Review("Cairns",
				"The gateway to Australia's Great Barrier Reef. "
						+ "Explore the Aboriginal Cultural Park, which tells stories of indigenous Aboriginal and T"
						+ "orres Strait Islander people with music and dance.",
				"/images/cairns.jpeg", australia, arts, beach, island));
		Review paris = reviewRepo.save(new Review("Paris",
				"Filled with highly regarded museums, monuments, churches and iconic sights. Amazing food and wine.",
				"/images/paris.jpeg", europe, arts, architecture, shopping, gastronomy));
		Review rome = reviewRepo.save(new Review("Rome", "Are you not entertained? Enough said.", "/images/rome.jpeg", europe, culture, arts, architecture));
		Review london = reviewRepo
				.save(new Review("London", "Fish and chips anyone? This is an invigorating two-millenia old "
						+ "city with very pricey hotels and tiny living spaces.", "/images/london.jpeg", europe, shopping, architecture));
		Review peru = reviewRepo.save(
				new Review("Peru", "Visit the Incan Kingdom, one of the continent's greatest archaeological sites",
						"/images/peru.jpeg", southAmerica, hot, ancient, arts, culture));
		Review ecuador = reviewRepo.save(new Review("Ecuador",
				"The Amazon is not for the light hearted but if you love to rough it,"
						+ "and adore a variety of animals including tarantulas, this is the spot for you.",
				"/images/ecuador.jpg", southAmerica, hot, culture, arts, architecture, wildlife));
		Review venezuela = reviewRepo.save(new Review("Venezuela",
				"The world's highest uninterrupted waterfall, "
						+ "the grasslands, rivers, and mountains. The poisonous arrow frogs...",
				"/images/venezuela.jpg", southAmerica, tropics, hot, island));
		Review haidaGwaii = reviewRepo.save(new Review("Haida Gwaii",
				"Remote, wild, and epically beautiful, Haida Gwaii " + "is in a league of its own. ", "/images/haidagwaii.jpg",
				northAmerica, island, wildlife, beach, tropics));
		Review hawaii = reviewRepo
				.save(new Review("Hawaii", "Hawaii is just another word for paradise. Shiny black volcanoes, "
						+ "sapphire blue water and the greenest palm trees.", "/images/hawaii.jpeg", northAmerica, scuba, island, beach, fish, tropics));
		Review alberta = reviewRepo.save(new Review("Alberta",
				"This area never fails to inspire. While you’re here, make time to see views from "
						+ "Johnston Canyon, Mt. Weed, Sulphur Mountain, and those iconic bright red chairs.",
				"/images/alberta.jpeg", northAmerica, mountains, prairie, forest));

	}

}
