import React from 'react';
import ServiceCard from './ServiceCard';

const ServiceSection: React.FC = () => {
  return (
      <section className="pt-3 pb-16">
        <div className="container mx-auto grid grid-cols-1 md:grid-cols-3 gap-8">
          <ServiceCard title="Diagnostic" description="Lorem ipsum dolor sit amet." link="#" />
          <ServiceCard title="Wellness" description="Lorem ipsum dolor sit amet." link="#" />
          <ServiceCard title="Surgery" description="Lorem ipsum dolor sit amet." link="#" />
        </div>
      </section>
  );
};

export default ServiceSection;
