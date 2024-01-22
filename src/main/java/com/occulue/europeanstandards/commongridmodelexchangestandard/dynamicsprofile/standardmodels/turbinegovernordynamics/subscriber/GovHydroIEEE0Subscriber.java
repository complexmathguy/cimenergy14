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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.subscriber;

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
 * Subscriber for GovHydroIEEE0 related events. .
 *
 * @author your_name_here
 */
@Component("govHydroIEEE0-subscriber")
public class GovHydroIEEE0Subscriber extends BaseSubscriber {

  public GovHydroIEEE0Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydroIEEE0>, GovHydroIEEE0> govHydroIEEE0Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydroIEEE0Query(),
        ResponseTypes.multipleInstancesOf(GovHydroIEEE0.class),
        ResponseTypes.instanceOf(GovHydroIEEE0.class));
  }

  public SubscriptionQueryResult<GovHydroIEEE0, GovHydroIEEE0> govHydroIEEE0Subscribe(
      @DestinationVariable UUID govHydroIEEE0Id) {
    return queryGateway.subscriptionQuery(
        new FindGovHydroIEEE0Query(new LoadGovHydroIEEE0Filter(govHydroIEEE0Id)),
        ResponseTypes.instanceOf(GovHydroIEEE0.class),
        ResponseTypes.instanceOf(GovHydroIEEE0.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
