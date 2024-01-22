/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for MeasurementValueQuality related events. .
 *
 * @author your_name_here
 */
@Component("measurementValueQuality-subscriber")
public class MeasurementValueQualitySubscriber extends BaseSubscriber {

  public MeasurementValueQualitySubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<MeasurementValueQuality>, MeasurementValueQuality>
      measurementValueQualitySubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllMeasurementValueQualityQuery(),
        ResponseTypes.multipleInstancesOf(MeasurementValueQuality.class),
        ResponseTypes.instanceOf(MeasurementValueQuality.class));
  }

  public SubscriptionQueryResult<MeasurementValueQuality, MeasurementValueQuality>
      measurementValueQualitySubscribe(@DestinationVariable UUID measurementValueQualityId) {
    return queryGateway.subscriptionQuery(
        new FindMeasurementValueQualityQuery(
            new LoadMeasurementValueQualityFilter(measurementValueQualityId)),
        ResponseTypes.instanceOf(MeasurementValueQuality.class),
        ResponseTypes.instanceOf(MeasurementValueQuality.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
