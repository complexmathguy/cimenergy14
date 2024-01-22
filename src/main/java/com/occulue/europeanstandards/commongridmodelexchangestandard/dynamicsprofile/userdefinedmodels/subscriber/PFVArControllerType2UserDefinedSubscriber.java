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
 * Subscriber for PFVArControllerType2UserDefined related events. .
 *
 * @author your_name_here
 */
@Component("pFVArControllerType2UserDefined-subscriber")
public class PFVArControllerType2UserDefinedSubscriber extends BaseSubscriber {

  public PFVArControllerType2UserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<PFVArControllerType2UserDefined>, PFVArControllerType2UserDefined>
      pFVArControllerType2UserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPFVArControllerType2UserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(PFVArControllerType2UserDefined.class),
        ResponseTypes.instanceOf(PFVArControllerType2UserDefined.class));
  }

  public SubscriptionQueryResult<PFVArControllerType2UserDefined, PFVArControllerType2UserDefined>
      pFVArControllerType2UserDefinedSubscribe(
          @DestinationVariable UUID pFVArControllerType2UserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindPFVArControllerType2UserDefinedQuery(
            new LoadPFVArControllerType2UserDefinedFilter(pFVArControllerType2UserDefinedId)),
        ResponseTypes.instanceOf(PFVArControllerType2UserDefined.class),
        ResponseTypes.instanceOf(PFVArControllerType2UserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
