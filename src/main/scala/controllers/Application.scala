package controllers

import play.api.mvc._
import com.fasterxml.jackson.databind.ObjectMapper

case class Building(name: String, height: Int, city: String)

class Application extends Controller {

  def index = Action {
    import com.fasterxml.jackson.module.scala.DefaultScalaModule

    val json =
      """
        |[
        |  {
        |    "Building": "Burj Khalifa",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "828",
        |    "Floors": 163,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Shanghai Tower",
        |    "City": "Shanghai",
        |    "Country": "China",
        |    "Height (m)": "632",
        |    "Floors": 121,
        |    "Built": 2014
        |  },
        |  {
        |    "Building": "Makkah Royal Clock Tower Hotel",
        |    "City": "Mecca",
        |    "Country": "Saudi Arabia",
        |    "Height (m)": "601",
        |    "Floors": 120,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "One World Trade Center",
        |    "City": "New York City",
        |    "Country": "USA",
        |    "Height (m)": "541.3",
        |    "Floors": 104,
        |    "Built": 2013
        |  },
        |  {
        |    "Building": "Taipei 101",
        |    "City": "Taipei",
        |    "Country": "Taiwan",
        |    "Height (m)": "509",
        |    "Floors": 101,
        |    "Built": 2004
        |  },
        |  {
        |    "Building": "Shanghai World Financial Center",
        |    "City": "Shanghai",
        |    "Country": "China",
        |    "Height (m)": "492",
        |    "Floors": 101,
        |    "Built": 2008
        |  },
        |  {
        |    "Building": "International Commerce Centre",
        |    "City": "Hong Kong",
        |    "Country": "Hong Kong",
        |    "Height (m)": "484",
        |    "Floors": 118,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Petronas Tower 1",
        |    "City": "Kuala Lumpur",
        |    "Country": "Malaysia",
        |    "Height (m)": "452",
        |    "Floors": 88,
        |    "Built": 1998
        |  },
        |  {
        |    "Building": "Petronas Tower 2",
        |    "City": "Kuala Lumpur",
        |    "Country": "Malaysia",
        |    "Height (m)": "452",
        |    "Floors": 88,
        |    "Built": 1998
        |  },
        |  {
        |    "Building": "Zifeng Tower",
        |    "City": "Nanjing",
        |    "Country": "China",
        |    "Height (m)": "450",
        |    "Floors": 89,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Willis Tower (Formerly Sears Tower)",
        |    "City": "Chicago",
        |    "Country": "USA",
        |    "Height (m)": "442 m",
        |    "Floors": 108,
        |    "Built": 1973
        |  },
        |  {
        |    "Building": "Kingkey 100",
        |    "City": "Shenzhen",
        |    "Country": "China",
        |    "Height (m)": "442",
        |    "Floors": 100,
        |    "Built": 2011
        |  },
        |  {
        |    "Building": "Guangzhou International Finance Center",
        |    "City": "Guangzhou",
        |    "Country": "China",
        |    "Height (m)": "440",
        |    "Floors": 103,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Dream Dubai Marina",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "432",
        |    "Floors": 101,
        |    "Built": 2014
        |  },
        |  {
        |    "Building": "Trump International Hotel and Tower",
        |    "City": "Chicago",
        |    "Country": "USA",
        |    "Height (m)": "423",
        |    "Floors": 98,
        |    "Built": 2009
        |  },
        |  {
        |    "Building": "Jin Mao Tower",
        |    "City": "Shanghai",
        |    "Country": "China",
        |    "Height (m)": "421",
        |    "Floors": 88,
        |    "Built": 1999
        |  },
        |  {
        |    "Building": "Princess Tower",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "414 m",
        |    "Floors": 101,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Al Hamra Firdous Tower",
        |    "City": "Kuwait City",
        |    "Country": "Kuwait",
        |    "Height (m)": "413",
        |    "Floors": 77,
        |    "Built": 2011
        |  },
        |  {
        |    "Building": "2 International Finance Centre",
        |    "City": "Hong Kong",
        |    "Country": "Hong Kong",
        |    "Height (m)": "412",
        |    "Floors": 88,
        |    "Built": 2003
        |  },
        |  {
        |    "Building": "23 Marina",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "395",
        |    "Floors": 89,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "CITIC Plaza",
        |    "City": "Guangzhou",
        |    "Country": "China",
        |    "Height (m)": "391",
        |    "Floors": 80,
        |    "Built": 1997
        |  },
        |  {
        |    "Building": "Shun Hing Square",
        |    "City": "Shenzhen",
        |    "Country": "China",
        |    "Height (m)": "384",
        |    "Floors": 69,
        |    "Built": 1996
        |  },
        |  {
        |    "Building": "Central Market Project",
        |    "City": "Abu Dhabi",
        |    "Country": "UAE",
        |    "Height (m)": "381",
        |    "Floors": 88,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Empire State Building",
        |    "City": "New York City",
        |    "Country": "USA",
        |    "Height (m)": "381",
        |    "Floors": 102,
        |    "Built": 1931
        |  },
        |  {
        |    "Building": "Elite Residence",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "380.5",
        |    "Floors": 87,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Tuntex Sky Tower",
        |    "City": "Kaohsiung",
        |    "Country": "Taiwan",
        |    "Height (m)": "378",
        |    "Floors": 85,
        |    "Built": 1997
        |  },
        |  {
        |    "Building": "Central Plaza",
        |    "City": "Hong Kong",
        |    "Country": "Hong Kong",
        |    "Height (m)": "374",
        |    "Floors": 78,
        |    "Built": 1992
        |  },
        |  {
        |    "Building": "Bank of China Tower",
        |    "City": "Hong Kong",
        |    "Country": "Hong Kong",
        |    "Height (m)": "367",
        |    "Floors": 70,
        |    "Built": 1990
        |  },
        |  {
        |    "Building": "Bank of America Tower",
        |    "City": "New York City",
        |    "Country": "USA",
        |    "Height (m)": "366",
        |    "Floors": 54,
        |    "Built": 2009
        |  },
        |  {
        |    "Building": "Almas Tower",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "363",
        |    "Floors": 68,
        |    "Built": 2009
        |  },
        |  {
        |    "Building": "The Pinnacle",
        |    "City": "Guangzhou",
        |    "Country": "China",
        |    "Height (m)": "360",
        |    "Floors": 60,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "SEG Plaza",
        |    "City": "Shenzhen",
        |    "Country": "China",
        |    "Height (m)": "356",
        |    "Floors": 70,
        |    "Built": 2000
        |  },
        |  {
        |    "Building": "JW Marriott Marquis Dubai Tower 1",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "355",
        |    "Floors": 82,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "JW Marriott Marquis Dubai Tower 2",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "355",
        |    "Floors": 82,
        |    "Built": 2013
        |  },
        |  {
        |    "Building": "Emirates Office Tower",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "355",
        |    "Floors": 54,
        |    "Built": 2000
        |  },
        |  {
        |    "Building": "Aon Center",
        |    "City": "Chicago",
        |    "Country": "USA",
        |    "Height (m)": "346",
        |    "Floors": 83,
        |    "Built": 1973
        |  },
        |  {
        |    "Building": "The Center",
        |    "City": "Hong Kong",
        |    "Country": "Hong Kong",
        |    "Height (m)": "346",
        |    "Floors": 73,
        |    "Built": 1998
        |  },
        |  {
        |    "Building": "Keangnam Hanoi Landmark Tower",
        |    "City": "Hanoi",
        |    "Country": "Vietnam",
        |    "Height (m)": "345",
        |    "Floors": 72,
        |    "Built": 2011
        |  },
        |  {
        |    "Building": "John Hancock Center",
        |    "City": "Chicago",
        |    "Country": "USA",
        |    "Height (m)": "344",
        |    "Floors": 100,
        |    "Built": 1969
        |  },
        |  {
        |    "Building": "Ahmed Abdul Rahim Al Attar Tower",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "342",
        |    "Floors": 76,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Mercury City Tower",
        |    "City": "Moscow",
        |    "Country": "Russia",
        |    "Height (m)": "339",
        |    "Floors": 75,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Hefei Feicui TV Tower",
        |    "City": "Hefei",
        |    "Country": "China",
        |    "Height (m)": "339",
        |    "Floors": 75,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Tianjin World Financial Center",
        |    "City": "Tianjin",
        |    "Country": "China",
        |    "Height (m)": "337",
        |    "Floors": 79,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "The Marina Torch",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "337",
        |    "Floors": 79,
        |    "Built": 2011
        |  },
        |  {
        |    "Building": "Shimao International Plaza",
        |    "City": "Shanghai",
        |    "Country": "China",
        |    "Height (m)": "333",
        |    "Floors": 61,
        |    "Built": 2005
        |  },
        |  {
        |    "Building": "Rose Tower",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "333",
        |    "Floors": 72,
        |    "Built": 2007
        |  },
        |  {
        |    "Building": "Modern Media Center",
        |    "City": "Changzhou",
        |    "Country": "China",
        |    "Height (m)": "332",
        |    "Floors": 57,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Minsheng Bank Building",
        |    "City": "Wuhan",
        |    "Country": "China",
        |    "Height (m)": "331",
        |    "Floors": 68,
        |    "Built": 2007
        |  },
        |  {
        |    "Building": "China World Trade Center Tower 3",
        |    "City": "Beijing",
        |    "Country": "China",
        |    "Height (m)": "330",
        |    "Floors": 74,
        |    "Built": 2009
        |  },
        |  {
        |    "Building": "Ryugyong Hotel",
        |    "City": "Pyongyang",
        |    "Country": "North Korea",
        |    "Height (m)": "330",
        |    "Floors": 105,
        |    "Built": 1992
        |  },
        |  {
        |    "Building": "The Index",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "328",
        |    "Floors": 80,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Al Yaqoub Tower",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "328",
        |    "Floors": 69,
        |    "Built": 2013
        |  },
        |  {
        |    "Building": "Longxi International Hotel",
        |    "City": "Huaxi Village",
        |    "Country": "China",
        |    "Height (m)": "328",
        |    "Floors": 72,
        |    "Built": 2011
        |  },
        |  {
        |    "Building": "The Landmark",
        |    "City": "Abu Dhabi",
        |    "Country": "UAE",
        |    "Height (m)": "324",
        |    "Floors": 72,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Deji Plaza Phase 2",
        |    "City": "Nanjing",
        |    "Country": "China",
        |    "Height (m)": "324",
        |    "Floors": 62,
        |    "Built": 2013
        |  },
        |  {
        |    "Building": "Q1",
        |    "City": "Gold Coast",
        |    "Country": "Australia",
        |    "Height (m)": "323",
        |    "Floors": 80,
        |    "Built": 2005
        |  },
        |  {
        |    "Building": "Wenzhou World Trade Center",
        |    "City": "Wenzhou",
        |    "Country": "China",
        |    "Height (m)": "322",
        |    "Floors": 68,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Burj Al Arab",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "321",
        |    "Floors": 60,
        |    "Built": 1999
        |  },
        |  {
        |    "Building": "Nina Tower",
        |    "City": "Hong Kong",
        |    "Country": "Hong Kong",
        |    "Height (m)": "319",
        |    "Floors": 80,
        |    "Built": 2007
        |  },
        |  {
        |    "Building": "Chrysler Building",
        |    "City": "New York City",
        |    "Country": "USA",
        |    "Height (m)": "319",
        |    "Floors": 77,
        |    "Built": 1930
        |  },
        |  {
        |    "Building": "New York Times Building",
        |    "City": "New York City",
        |    "Country": "USA",
        |    "Height (m)": "319",
        |    "Floors": 52,
        |    "Built": 2007
        |  },
        |  {
        |    "Building": "HHHR Tower",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "317",
        |    "Floors": 72,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Bank of America Plaza",
        |    "City": "Atlanta",
        |    "Country": "USA",
        |    "Height (m)": "317",
        |    "Floors": 55,
        |    "Built": 1992
        |  },
        |  {
        |    "Building": "Moi Center",
        |    "City": "Shenyang",
        |    "Country": "China",
        |    "Height (m)": "311",
        |    "Floors": 75,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "U.S. Bank Tower",
        |    "City": "Los Angeles",
        |    "Country": "USA",
        |    "Height (m)": "310",
        |    "Floors": 73,
        |    "Built": 1989
        |  },
        |  {
        |    "Building": "Menara Telekom",
        |    "City": "Kuala Lumpur",
        |    "Country": "Malaysia",
        |    "Height (m)": "310",
        |    "Floors": 55,
        |    "Built": 2001
        |  },
        |  {
        |    "Building": "Ocean Heights",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "310",
        |    "Floors": 82,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Sky Tower",
        |    "City": "Abu Dhabi",
        |    "Country": "UAE",
        |    "Height (m)": "310",
        |    "Floors": 74,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Pearl River Tower",
        |    "City": "Guangzhou",
        |    "Country": "China",
        |    "Height (m)": "310",
        |    "Floors": 71,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Jumeirah Emirates Towers Hotel",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "309",
        |    "Floors": 56,
        |    "Built": 2000
        |  },
        |  {
        |    "Building": "Eurasia",
        |    "City": "Moscow",
        |    "Country": "Russia",
        |    "Height (m)": "309",
        |    "Floors": 72,
        |    "Built": 2013
        |  },
        |  {
        |    "Building": "Burj Rafal",
        |    "City": "Riyadh",
        |    "Country": "Saudi Arabia",
        |    "Height (m)": "308",
        |    "Floors": 68,
        |    "Built": 2014
        |  },
        |  {
        |    "Building": "Franklin Center",
        |    "City": "Chicago",
        |    "Country": "USA",
        |    "Height (m)": "307",
        |    "Floors": 60,
        |    "Built": 1989
        |  },
        |  {
        |    "Building": "Cayan Tower",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "306",
        |    "Floors": 76,
        |    "Built": 2013
        |  },
        |  {
        |    "Building": "One57",
        |    "City": "New York City",
        |    "Country": "USA",
        |    "Height (m)": "306",
        |    "Floors": 75,
        |    "Built": 2013
        |  },
        |  {
        |    "Building": "East Pacific Center Tower A",
        |    "City": "Shenzhen",
        |    "Country": "China",
        |    "Height (m)": "306",
        |    "Floors": 85,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "The Shard",
        |    "City": "London",
        |    "Country": "UK",
        |    "Height (m)": "306",
        |    "Floors": 72,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "The Address Downtown Burj Khalifa",
        |    "City": "Dubai",
        |    "Country": "UAE",
        |    "Height (m)": "306",
        |    "Floors": 63,
        |    "Built": 2008
        |  },
        |  {
        |    "Building": "JPMorgan Chase Tower",
        |    "City": "Houston",
        |    "Country": "USA",
        |    "Height (m)": "305",
        |    "Floors": 75,
        |    "Built": 1982
        |  },
        |  {
        |    "Building": "Etihad Tower 2",
        |    "City": "Abu Dhabi",
        |    "Country": "UAE",
        |    "Height (m)": "305",
        |    "Floors": 79,
        |    "Built": 2011
        |  },
        |  {
        |    "Building": "Northeast Asia Trade Tower",
        |    "City": "Incheon",
        |    "Country": "South Korea",
        |    "Height (m)": "305",
        |    "Floors": 68,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "Baiyoke Tower II",
        |    "City": "Bangkok",
        |    "Country": "Thailand",
        |    "Height (m)": "304",
        |    "Floors": 85,
        |    "Built": 1997
        |  },
        |  {
        |    "Building": "Two Prudential Plaza",
        |    "City": "Chicago",
        |    "Country": "USA",
        |    "Height (m)": "303",
        |    "Floors": 64,
        |    "Built": 1990
        |  },
        |  {
        |    "Building": "Moi City",
        |    "City": "Wuxi",
        |    "Country": "China",
        |    "Height (m)": "303",
        |    "Floors": 72,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Leatop Plaza",
        |    "City": "Guangzhou",
        |    "Country": "China",
        |    "Height (m)": "303",
        |    "Floors": 65,
        |    "Built": 2011
        |  },
        |  {
        |    "Building": "Wells Fargo Plaza",
        |    "City": "Houston",
        |    "Country": "USA",
        |    "Height (m)": "302",
        |    "Floors": 71,
        |    "Built": 1983
        |  },
        |  {
        |    "Building": "Kingdom Centre",
        |    "City": "Riyadh",
        |    "Country": "Saudi Arabia",
        |    "Height (m)": "302",
        |    "Floors": 41,
        |    "Built": 2002
        |  },
        |  {
        |    "Building": "Gate of the Orient",
        |    "City": "Suzhou",
        |    "Country": "China",
        |    "Height (m)": "302",
        |    "Floors": 68,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "Moscow Tower",
        |    "City": "Moscow",
        |    "Country": "Russia",
        |    "Height (m)": "302",
        |    "Floors": 76,
        |    "Built": 2010
        |  },
        |  {
        |    "Building": "We've the Zenith Tower A",
        |    "City": "Busan",
        |    "Country": "South Korea",
        |    "Height (m)": "301",
        |    "Floors": 80,
        |    "Built": 2011
        |  },
        |  {
        |    "Building": "Aspire Tower",
        |    "City": "Doha",
        |    "Country": "Qatar",
        |    "Height (m)": "300",
        |    "Floors": 36,
        |    "Built": 2007
        |  },
        |  {
        |    "Building": "Arraya 2",
        |    "City": "Kuwait City",
        |    "Country": "Kuwait",
        |    "Height (m)": "300",
        |    "Floors": 60,
        |    "Built": 2009
        |  },
        |  {
        |    "Building": "Gran Torre Santiago",
        |    "City": "Santiago",
        |    "Country": "Chile",
        |    "Height (m)": "300",
        |    "Floors": 64,
        |    "Built": 2012
        |  },
        |  {
        |    "Building": "One Island East",
        |    "City": "Hong Kong",
        |    "Country": "Hong Kong",
        |    "Height (m)": "298",
        |    "Floors": 67,
        |    "Built": 2008
        |  }
        |]
      """.stripMargin


    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)

    val buildings = mapper.readValue(json, classOf[List[Building]])

    Ok(views.html.index(buildings))
  }

}
