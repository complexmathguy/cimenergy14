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
 * Subscriber for GovGAST related events. .
 *
 * @author your_name_here
 */
@Component("govGAST-subscriber")
public class GovGASTSubscriber extends BaseSubscriber {

  public GovGASTSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovGAST>, GovGAST> govGASTSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovGASTQuery(),
        ResponseTypes.multipleInstancesOf(GovGAST.class),
        ResponseTypes.instanceOf(GovGAST.class));
  }

  public SubscriptionQueryResult<GovGAST, GovGAST> govGASTSubscribe(
      @DestinationVariable UUID govGASTId) {
    return queryGateway.subscriptionQuery(
        new FindGovGASTQuery(new LoadGovGASTFilter(govGASTId)),
        ResponseTypes.instanceOf(GovGAST.class),
        ResponseTypes.instanceOf(GovGAST.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
