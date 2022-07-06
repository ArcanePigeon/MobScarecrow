# Changelog

All notable changes to this project will be documented in this file.

## [1.0.0] - 12/26/2021
### Added
- All hostile mob scarecrow.
- Spider scarecrow.
- Creeper scarecrow.
- Zombie scarecrow.
- Skeleton scarecrow.

## [1.1.0] - 1/27/2022
### Added
- Turtle scarecrow.
- Endermite scarecrow.
- Statue variants.
### Fixed
- Improved efficiency of scarecrow checks to reduce lag.
- Fixed bug that improperly checked for scarecrow distance.
### Changed
- Scarecrow effective radius is now a circle instead of a square; This change is the result of a bug fix.

## [1.2.0] - 2/8/2022
### Added
- Game Rule to set how far a scarecrow can scare mobs.

## [1.2.1] - 3/2/2022
### Updated
- Mob Scarecrows is now on 1.18.2
### Fixed
- Servers required the gamerule to be set as it was not properly initalized.

## [1.2.2] - 3/17/2022
### Changed
- Gamerule has been removed in favor of a config file.
- Voxel Shapes for scarecrows have been fixed

## [2.0.0] - 6/11/2022
### Added
- 16 new plushies and 1 new scarecrow.
- Compatibility with mobs that use brain class.
### Changed
- Scarecrows are now entities like armor stands.
- Scarecrows now have a new design.
### Fixed
- Scarecrow checking code fixed to dramatically reduce lag.
### Removed
- Statue variants (will hopefully be added back in a future update)

## [2.1.0] - 6/15/2022
### Changed
- New less loud plushie sounds.
- Goals are added to entities via the MobEntity class (this allows for many modded entities to interact with scarecrows)
### Fixed
- Crash when an entity converted into another entity.
- Entities that converted to another entity would no longer flee from scarecrows.

## [2.2.0] - 6/15/2022
### Updated
- Now for 1.19!
### Added
- Tooltips telling the player what each scarecrow does

## [2.2.1] - 7/5/2022
### Fixed
- Fixed entity names not displaying properly