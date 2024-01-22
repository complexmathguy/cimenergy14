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
 * Subscriber for GovHydro1 related events. .
 *
 * @author your_name_here
 */
@Component("govHydro1-subscriber")
public class GovHydro1Subscriber extends BaseSubscriber {

  public GovHydro1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydro1>, GovHydro1> govHydro1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydro1Query(),
        ResponseTypes.multipleInstancesOf(GovHydro1.class),
        ResponseTypes.instanceOf(GovHydro1.class));
  }

  public SubscriptionQueryResult<GovHydro1, GovHydro1> govHydro1Subscribe(
      @DestinationVariable UUID govHydro1Id) {
    return queryGateway.subscriptionQuery(
        new FindGovHydro1Query(new LoadGovHydro1Filter(govHydro1Id)),
        ResponseTypes.instanceOf(GovHydro1.class),
        ResponseTypes.instanceOf(GovHydro1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
