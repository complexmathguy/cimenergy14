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
 * Subscriber for GovHydro4 related events. .
 *
 * @author your_name_here
 */
@Component("govHydro4-subscriber")
public class GovHydro4Subscriber extends BaseSubscriber {

  public GovHydro4Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydro4>, GovHydro4> govHydro4Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydro4Query(),
        ResponseTypes.multipleInstancesOf(GovHydro4.class),
        ResponseTypes.instanceOf(GovHydro4.class));
  }

  public SubscriptionQueryResult<GovHydro4, GovHydro4> govHydro4Subscribe(
      @DestinationVariable UUID govHydro4Id) {
    return queryGateway.subscriptionQuery(
        new FindGovHydro4Query(new LoadGovHydro4Filter(govHydro4Id)),
        ResponseTypes.instanceOf(GovHydro4.class),
        ResponseTypes.instanceOf(GovHydro4.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
