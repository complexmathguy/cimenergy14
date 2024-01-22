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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for RatioTapChangerTable related events. .
 *
 * @author your_name_here
 */
@Component("ratioTapChangerTable-subscriber")
public class RatioTapChangerTableSubscriber extends BaseSubscriber {

  public RatioTapChangerTableSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RatioTapChangerTable>, RatioTapChangerTable>
      ratioTapChangerTableSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRatioTapChangerTableQuery(),
        ResponseTypes.multipleInstancesOf(RatioTapChangerTable.class),
        ResponseTypes.instanceOf(RatioTapChangerTable.class));
  }

  public SubscriptionQueryResult<RatioTapChangerTable, RatioTapChangerTable>
      ratioTapChangerTableSubscribe(@DestinationVariable UUID ratioTapChangerTableId) {
    return queryGateway.subscriptionQuery(
        new FindRatioTapChangerTableQuery(
            new LoadRatioTapChangerTableFilter(ratioTapChangerTableId)),
        ResponseTypes.instanceOf(RatioTapChangerTable.class),
        ResponseTypes.instanceOf(RatioTapChangerTable.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
