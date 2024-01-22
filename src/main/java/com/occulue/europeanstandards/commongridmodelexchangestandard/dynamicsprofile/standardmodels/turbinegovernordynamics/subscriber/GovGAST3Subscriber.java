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
 * Subscriber for GovGAST3 related events. .
 *
 * @author your_name_here
 */
@Component("govGAST3-subscriber")
public class GovGAST3Subscriber extends BaseSubscriber {

  public GovGAST3Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovGAST3>, GovGAST3> govGAST3Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovGAST3Query(),
        ResponseTypes.multipleInstancesOf(GovGAST3.class),
        ResponseTypes.instanceOf(GovGAST3.class));
  }

  public SubscriptionQueryResult<GovGAST3, GovGAST3> govGAST3Subscribe(
      @DestinationVariable UUID govGAST3Id) {
    return queryGateway.subscriptionQuery(
        new FindGovGAST3Query(new LoadGovGAST3Filter(govGAST3Id)),
        ResponseTypes.instanceOf(GovGAST3.class),
        ResponseTypes.instanceOf(GovGAST3.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
