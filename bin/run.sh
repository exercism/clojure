#!/usr/bin/env bash

# Synopsis:
# Run the test runner on a solution.

# Arguments:
# $1: exercise slug
# $2: absolute path to solution folder
# $3: absolute path to output directory

# Output:
# Writes the test results to a results.json file in the passed-in output directory.
# The test results are formatted according to the specifications at https://github.com/exercism/docs/blob/main/building/tooling/test-runners/interface.md

# Example:
# ./bin/run.sh two-fer /absolute/path/to/two-fer/solution/folder/ /absolute/path/to/output/directory/

# If any required arguments is missing, print the usage and exit
if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ]; then
    echo "usage: ./bin/run.sh exercise-slug /absolute/path/to/two-fer/solution/folder/ /absolute/path/to/output/directory/"
    exit 1
fi

slug="$1"
input_dir="${2%/}"
output_dir="${3%/}"
results_file="${output_dir}/results.json"

# Create the output directory if it doesn't exist
mkdir -p "${output_dir}"

echo "${slug}: testing..."


# Run the tests for the provided implementation file and redirect stdout and
# stderr to capture it
test_output=$(./test-runner.clj "${slug}" "${input_dir}/" "${output_dir}" 2>&1)
exit_code=$?


# Write the results.json file based on the exit code of the command that was 
# just executed that tested the implementation file
if [ $exit_code -eq 0 ]; then
    echo "${test_output}" > ${results_file}
else
    jq -n --arg output "${test_output}" '{"version" : 2, "status" : "error", "message" : $output}' > ${results_file}
fi

echo "${output_dir}"

echo "${slug}: done"
