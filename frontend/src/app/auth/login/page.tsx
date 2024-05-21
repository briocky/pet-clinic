import React from "react";
import Image from "next/image";

export default function Login() {
  return (
      <section className="h-screen">
        <div className="container h-full px-6 pt-5">
          <div className="flex">
            <div>
            <Image width={300} height={300} src={'/images/logo.svg'} alt={'logo'} />
            </div>
            <Image className="absolute right-40 -z-10" width={200} height={200} src={'/images/dog.png'} alt={'dog'} />
          </div>

          <div className="g-6 flex pt-10 flex-wrap items-center justify-center lg:justify-between">
            {/* <!-- Left column container with background--> */}
            <div className="mb-12 md:mb-0 md:w-8/12 lg:w-6/12">
              <img
                  src="https://tecdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
                  className="w-full"
                  alt="Phone image"
              />
            </div>

            {/* <!-- Right column container with form --> */}
            <div className="md:w-8/12 lg:ml-6 lg:w-5/12">
              <form>
                {/* <!-- Email input --> */}
                <div className="mb-6">
                  <input
                      type="email"
                      placeholder="Email address"
                      className="w-full px-4 py-2 text-lg border rounded-lg focus:outline-none focus:ring-2 focus:ring-primary"
                  />
                </div>

                {/* <!-- Password input --> */}
                <div className="mb-6">
                  <input
                      type="password"
                      placeholder="Password"
                      className="w-full px-4 py-2 text-lg border rounded-lg focus:outline-none focus:ring-2 focus:ring-primary"
                  />
                </div>

                {/* <!-- Remember me checkbox --> */}
                <div className="mb-6 flex items-center justify-between">
                  <div className="flex items-center">
                    <input
                        className="form-checkbox h-4 w-4 text-primary"
                        type="checkbox"
                        id="exampleCheck3"
                        defaultChecked
                    />
                    <label
                        className="ml-2 text-sm font-medium text-gray-600"
                        htmlFor="exampleCheck3"
                    >
                      Remember me
                    </label>
                  </div>

                  {/* <!-- Forgot password link --> */}
                  <a
                      href="#!"
                      className="text-gray-900 transition duration-150 ease-in-out hover:text-primary-600 focus:text-primary-600 active:text-primary-700 dark:text-primary-400 dark:hover:text-primary-500 dark:focus:text-primary-500 dark:active:text-primary-600"
                  >
                    Forgot password?
                  </a>
                </div>

                {/* <!-- Submit button --> */}
                <button
                    type="submit"
                    className="w-full px-7 py-3 text-sm font-medium uppercase leading-normal bg-yellow-500 rounded shadow-md transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-lg focus:bg-primary-600 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-lg"
                >
                  Sign in
                </button>

                {/* <!-- Divider --> */}
                <div className="my-4 flex items-center before:flex-1 before:border-t before:border-neutral-400 after:flex-1 after:border-t after:border-neutral-400">
                  <p className="mx-4 mb-0 text-center font-semibold dark:text-neutral-400">
                    OR
                  </p>
                </div>

                {/* <!-- Social login buttons --> */}
                <a
                    className="mb-3 flex w-full items-center justify-center px-7 py-3 text-center text-sm font-medium uppercase leading-normal text-white bg-primary rounded shadow-md transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-lg focus:bg-primary-600 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-lg"
                    style={{ backgroundColor: "#3b5998" }}
                    href="#!"
                    role="button"
                >
                  <svg
                      xmlns="http://www.w3.org/2000/svg"
                      className="mr-2 h-3.5 w-3.5"
                      fill="currentColor"
                      viewBox="0 0 24 24"
                  >
                    <path d="M9 8h-3v4h3v12h5v-12h3.642l.358-4h-4v-1.667c0-.955.192-1.333 1.115-1.333h2.885v-5h-3.808c-3.596 0-5.192 1.583-5.192 4.615v3.385z" />
                  </svg>
                  Continue with Facebook
                </a>

                <a
                    className="mb-3 flex w-full items-center justify-center px-7 py-3 text-center text-sm font-medium uppercase leading-normal text-white bg-info rounded shadow-md transition duration-150 ease-in-out hover:bg-info-600 hover:shadow-lg focus:bg-info-600 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-info-700 active:shadow-lg"
                    style={{ backgroundColor: "#55acee" }}
                    href="#!"
                    role="button"
                >
                  <svg
                      xmlns="http://www.w3.org/2000/svg"
                      className="mr-2 h-3.5 w-3.5"
                      fill="currentColor"
                      viewBox="0 0 24 24"
                  >
                    <path d="M24 4.557c-.883.392-1.832.656-2.828.775 1.017-.609 1.798-1.574 2.165-2.724-.951.564-2.005.974-3.127 1.195-.897-.957-2.178-1.555-3.594-1.555-3.179 0-5.515 2.966-4.797 6.045-4.091-.205-7.719-2.165-10.148-5.144-1.29 2.213-.669 5.108 1.523 6.574-.806-.026-1.566-.247-2.229-.616-.054 2.281 1.581 4.415 3.949 4.89-.693.188-1.452.232-2.224.084.626 1.956 2.444 3.379 4.6 3.419-2.07 1.623-4.678 2.348-7.29 2.04 2.179 1.397 4.768 2.212 7.548 2.212 9.142 0 14.307-7.721 13.995-14.646.962-.695 1.797-1.562 2.457-2.549z" />
                  </svg>
                  Continue with Twitter
                </a>
              </form>
            </div>
          </div>
        </div>
      </section>
  );
}
