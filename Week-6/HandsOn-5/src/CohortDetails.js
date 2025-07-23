import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = () => {
  const cohorts = [
    {
      id: 1,
      name: 'INTADMDF10 -.NET FSD',
      startDate: '22-Feb-2022',
      status: 'Scheduled',
      coach: 'Aathma',
      trainer: 'Jojo Jose',
    },
    {
      id: 2,
      name: 'ADM21JF014 - Java FSD',
      startDate: '10-Sep-2021',
      status: 'Ongoing',
      coach: 'Apoorv',
      trainer: 'Elisa Smith',
    },
    {
      id: 3,
      name: 'CDBJF21025 - Java FSD',
      startDate: '24-Dec-2021',
      status: 'Ongoing',
      coach: 'Aathma',
      trainer: 'John Doe',
    },
  ];

  return (
    <div>
      <h2>Cohorts Details</h2>
      {cohorts.map((cohort) => (
        <div className={styles.box} key={cohort.id}>
          <h3 className={
            cohort.status.toLowerCase() === 'ongoing'
              ? styles.greenTitle
              : styles.blueTitle
          }>
            {cohort.name}
          </h3>
          <dl>
            <dt>Started On</dt>
            <dd>{cohort.startDate}</dd>

            <dt>Current Status</dt>
            <dd>{cohort.status}</dd>

            <dt>Coach</dt>
            <dd>{cohort.coach}</dd>

            <dt>Trainer</dt>
            <dd>{cohort.trainer}</dd>
          </dl>
        </div>
      ))}
    </div>
  );
};

export default CohortDetails;
