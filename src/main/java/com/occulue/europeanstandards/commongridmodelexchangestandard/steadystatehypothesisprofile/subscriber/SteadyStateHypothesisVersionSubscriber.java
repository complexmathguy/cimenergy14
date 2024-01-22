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
package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.subscriber;

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
 * Subscriber for SteadyStateHypothesisVersion related events. .
 *
 * @author your_name_here
 */
@Component("steadyStateHypothesisVersion-subscriber")
public class SteadyStateHypothesisVersionSubscriber extends BaseSubscriber {

  public SteadyStateHypothesisVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SteadyStateHypothesisVersion>, SteadyStateHypothesisVersion>
      steadyStateHypothesisVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSteadyStateHypothesisVersionQuery(),
        ResponseTypes.multipleInstancesOf(SteadyStateHypothesisVersion.class),
        ResponseTypes.instanceOf(SteadyStateHypothesisVersion.class));
  }

  public SubscriptionQueryResult<SteadyStateHypothesisVersion, SteadyStateHypothesisVersion>
      steadyStateHypothesisVersionSubscribe(
          @DestinationVariable UUID steadyStateHypothesisVersionId) {
    return queryGateway.subscriptionQuery(
        new FindSteadyStateHypothesisVersionQuery(
            new LoadSteadyStateHypothesisVersionFilter(steadyStateHypothesisVersionId)),
        ResponseTypes.instanceOf(SteadyStateHypothesisVersion.class),
        ResponseTypes.instanceOf(SteadyStateHypothesisVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
