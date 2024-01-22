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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.subscriber;

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
 * Subscriber for PFVArControllerType1UserDefined related events. .
 *
 * @author your_name_here
 */
@Component("pFVArControllerType1UserDefined-subscriber")
public class PFVArControllerType1UserDefinedSubscriber extends BaseSubscriber {

  public PFVArControllerType1UserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<PFVArControllerType1UserDefined>, PFVArControllerType1UserDefined>
      pFVArControllerType1UserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPFVArControllerType1UserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(PFVArControllerType1UserDefined.class),
        ResponseTypes.instanceOf(PFVArControllerType1UserDefined.class));
  }

  public SubscriptionQueryResult<PFVArControllerType1UserDefined, PFVArControllerType1UserDefined>
      pFVArControllerType1UserDefinedSubscribe(
          @DestinationVariable UUID pFVArControllerType1UserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindPFVArControllerType1UserDefinedQuery(
            new LoadPFVArControllerType1UserDefinedFilter(pFVArControllerType1UserDefinedId)),
        ResponseTypes.instanceOf(PFVArControllerType1UserDefined.class),
        ResponseTypes.instanceOf(PFVArControllerType1UserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
