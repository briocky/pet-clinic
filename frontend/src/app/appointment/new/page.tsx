"use client";

import React from "react";
import useUserAuth from "@/hook/useUserAuth";

const NewAppointment: React.FC = () => {
  useUserAuth();

  return (
      <>
        Protected appointment
      </>
  );
};

export default NewAppointment;