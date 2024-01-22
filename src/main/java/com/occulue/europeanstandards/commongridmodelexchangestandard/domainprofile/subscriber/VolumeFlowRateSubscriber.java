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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.subscriber;

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
 * Subscriber for VolumeFlowRate related events. .
 *
 * @author your_name_here
 */
@Component("volumeFlowRate-subscriber")
public class VolumeFlowRateSubscriber extends BaseSubscriber {

  public VolumeFlowRateSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VolumeFlowRate>, VolumeFlowRate> volumeFlowRateSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVolumeFlowRateQuery(),
        ResponseTypes.multipleInstancesOf(VolumeFlowRate.class),
        ResponseTypes.instanceOf(VolumeFlowRate.class));
  }

  public SubscriptionQueryResult<VolumeFlowRate, VolumeFlowRate> volumeFlowRateSubscribe(
      @DestinationVariable UUID volumeFlowRateId) {
    return queryGateway.subscriptionQuery(
        new FindVolumeFlowRateQuery(new LoadVolumeFlowRateFilter(volumeFlowRateId)),
        ResponseTypes.instanceOf(VolumeFlowRate.class),
        ResponseTypes.instanceOf(VolumeFlowRate.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
