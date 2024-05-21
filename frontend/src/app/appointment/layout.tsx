"use client";

import React from "react";
import ReduxProvider from "@/redux/ReduxProvider";

export default function AppointmentLayout(
    {children}: Readonly<{children: React.ReactNode;}>
) {
  return <ReduxProvider>{children}</ReduxProvider>
}