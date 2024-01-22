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
 * Subscriber for ResistancePerLength related events. .
 *
 * @author your_name_here
 */
@Component("resistancePerLength-subscriber")
public class ResistancePerLengthSubscriber extends BaseSubscriber {

  public ResistancePerLengthSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ResistancePerLength>, ResistancePerLength>
      resistancePerLengthSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllResistancePerLengthQuery(),
        ResponseTypes.multipleInstancesOf(ResistancePerLength.class),
        ResponseTypes.instanceOf(ResistancePerLength.class));
  }

  public SubscriptionQueryResult<ResistancePerLength, ResistancePerLength>
      resistancePerLengthSubscribe(@DestinationVariable UUID resistancePerLengthId) {
    return queryGateway.subscriptionQuery(
        new FindResistancePerLengthQuery(new LoadResistancePerLengthFilter(resistancePerLengthId)),
        ResponseTypes.instanceOf(ResistancePerLength.class),
        ResponseTypes.instanceOf(ResistancePerLength.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
