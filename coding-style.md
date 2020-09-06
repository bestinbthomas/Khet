# Kotlin Coding Style

## Rules

The standard rules followed b ktlint can be found [here](https://github.com/pinterest/ktlint)

##### Rules disabled
- No Unit returns (fun fn {} instead of fun fn: Unit {})
- No empty ({}) class bodies
- Imports ordered in alphabetic order with no spaces between major groups

## Ktlint usage

This project uses ktlint to ensure code standards are maintained throughout the project.

To perform a lint check, from the root directory of the project run:
```
./gradlew ktlintCheck
```

To format the code, run:
```
./gradlew ktlintFormat
```
