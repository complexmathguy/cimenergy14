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
 * Subscriber for GovGAST1 related events. .
 *
 * @author your_name_here
 */
@Component("govGAST1-subscriber")
public class GovGAST1Subscriber extends BaseSubscriber {

  public GovGAST1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovGAST1>, GovGAST1> govGAST1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovGAST1Query(),
        ResponseTypes.multipleInstancesOf(GovGAST1.class),
        ResponseTypes.instanceOf(GovGAST1.class));
  }

  public SubscriptionQueryResult<GovGAST1, GovGAST1> govGAST1Subscribe(
      @DestinationVariable UUID govGAST1Id) {
    return queryGateway.subscriptionQuery(
        new FindGovGAST1Query(new LoadGovGAST1Filter(govGAST1Id)),
        ResponseTypes.instanceOf(GovGAST1.class),
        ResponseTypes.instanceOf(GovGAST1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
