import React from 'react';
import StarRating from './StarRating';
import Header from "@/components/header/Header";
import Footer from "@/components/footer/Footer"; // Import the StarRating component

interface Review {
    author: string;
    date: string;
    rating: number;
    content: string;
    image: string; // Add image property
}

const Reviews: React.FC = () => {
    const reviews: Review[] = [
        {
            author: "John Doe",
            date: "June 12, 2024",
            rating: 5,
            content: "I've been bringing my pets to this clinic for years, and I couldn't be happier with the care they receive. The staff is always friendly and knowledgeable, and they go above and beyond to ensure the health and wellbeing of my furry family members.",
            image: "https://images.inc.com/uploaded_files/image/1920x1080/getty_481292845_77896.jpg"
        },
        {
            author: "Jane Smith",
            date: "May 25, 2024",
            rating: 4,
            content: "Great experience overall. The veterinarians here are top-notch, and they genuinely care about the animals they treat. The only reason I'm not giving five stars is because the waiting time can sometimes be a bit long.",
            image: "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVyc29ufGVufDB8fDB8fHww" // Add image path
        },
        {
            author: "David Johnson",
            date: "April 18, 2024",
            rating: 5,
            content: "I'm so grateful for the care my pet received at this clinic. The veterinarians were thorough in their examination and provided clear explanations of the treatment plan. My pet is now on the road to recovery, thanks to their expertise.",
            image: "https://www.pngitem.com/pimgs/m/106-1068071_black-person-png-black-man-business-png-transparent.png"
        },
        // Add more reviews as needed
    ];

    return (
        <>
            <Header/>
            <div className="min-h-screen py-12">
                <div className="container mx-auto px-4">
                    <h1 className="text-4xl font-extrabold text-gray-800 mb-8">Client Reviews</h1>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                        {reviews.map((review, index) => (
                            <div key={index} className="bg-white p-6 rounded-lg shadow-lg">
                                <div className="flex items-center mb-4">
                                    <img src={review.image} className="w-10 h-10 rounded-full mr-2"
                                         alt={review.author}/> {/* Add reviewer image */}
                                    <div>
                                        <StarRating
                                            rating={review.rating}/> {/* Use the StarRating component here */}
                                        <p className="text-gray-700">{review.author}</p>
                                        <p className="text-gray-600">{review.date}</p>
                                    </div>
                                </div>
                                <p className="text-gray-700">{review.content}</p>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    );
};

export default Reviews;
