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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for TurbineGovernorUserDefined as outlined for the CQRS pattern. All event handling and
 * query handling related to TurbineGovernorUserDefined are invoked here and dispersed as an event
 * to be handled elsewhere.
 *
 * <p>Commands are handled by TurbineGovernorUserDefinedAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("turbineGovernorUserDefined")
@Component("turbineGovernorUserDefined-projector")
public class TurbineGovernorUserDefinedProjector extends TurbineGovernorUserDefinedEntityProjector {

  // core constructor
  public TurbineGovernorUserDefinedProjector(
      TurbineGovernorUserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateTurbineGovernorUserDefinedEvent
   */
  @EventHandler(payloadType = CreateTurbineGovernorUserDefinedEvent.class)
  public void handle(CreateTurbineGovernorUserDefinedEvent event) {
    LOGGER.info("handling CreateTurbineGovernorUserDefinedEvent - " + event);
    TurbineGovernorUserDefined entity = new TurbineGovernorUserDefined();
    entity.setTurbineGovernorUserDefinedId(event.getTurbineGovernorUserDefinedId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbineGovernorUserDefined(entity);
  }

  /*
   * @param	event UpdateTurbineGovernorUserDefinedEvent
   */
  @EventHandler(payloadType = UpdateTurbineGovernorUserDefinedEvent.class)
  public void handle(UpdateTurbineGovernorUserDefinedEvent event) {
    LOGGER.info("handling UpdateTurbineGovernorUserDefinedEvent - " + event);

    TurbineGovernorUserDefined entity = new TurbineGovernorUserDefined();
    entity.setTurbineGovernorUserDefinedId(event.getTurbineGovernorUserDefinedId());
    entity.setProprietary(event.getProprietary());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbineGovernorUserDefined(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbineGovernorUserDefined(entity);
  }

  /*
   * @param	event DeleteTurbineGovernorUserDefinedEvent
   */
  @EventHandler(payloadType = DeleteTurbineGovernorUserDefinedEvent.class)
  public void handle(DeleteTurbineGovernorUserDefinedEvent event) {
    LOGGER.info("handling DeleteTurbineGovernorUserDefinedEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    TurbineGovernorUserDefined entity = delete(event.getTurbineGovernorUserDefinedId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbineGovernorUserDefined(entity);
  }

  /*
   * @param	event AssignProprietaryToTurbineGovernorUserDefinedEvent
   */
  @EventHandler(payloadType = AssignProprietaryToTurbineGovernorUserDefinedEvent.class)
  public void handle(AssignProprietaryToTurbineGovernorUserDefinedEvent event) {
    LOGGER.info("handling AssignProprietaryToTurbineGovernorUserDefinedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    TurbineGovernorUserDefined entity =
        assignProprietary(event.getTurbineGovernorUserDefinedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbineGovernorUserDefined(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbineGovernorUserDefined(entity);
  }

  /*
   * @param	event UnAssignProprietaryFromTurbineGovernorUserDefinedEvent
   */
  @EventHandler(payloadType = UnAssignProprietaryFromTurbineGovernorUserDefinedEvent.class)
  public void handle(UnAssignProprietaryFromTurbineGovernorUserDefinedEvent event) {
    LOGGER.info("handling UnAssignProprietaryFromTurbineGovernorUserDefinedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    TurbineGovernorUserDefined entity =
        unAssignProprietary(event.getTurbineGovernorUserDefinedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindTurbineGovernorUserDefined(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllTurbineGovernorUserDefined(entity);
  }

  /**
   * Method to retrieve the TurbineGovernorUserDefined via an TurbineGovernorUserDefinedPrimaryKey.
   *
   * @param id Long
   * @return TurbineGovernorUserDefined
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public TurbineGovernorUserDefined handle(FindTurbineGovernorUserDefinedQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getTurbineGovernorUserDefinedId());
  }

  /**
   * Method to retrieve a collection of all TurbineGovernorUserDefineds
   *
   * @param query FindAllTurbineGovernorUserDefinedQuery
   * @return List<TurbineGovernorUserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<TurbineGovernorUserDefined> handle(FindAllTurbineGovernorUserDefinedQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindTurbineGovernorUserDefined, but only if the id matches
   *
   * @param entity TurbineGovernorUserDefined
   */
  protected void emitFindTurbineGovernorUserDefined(TurbineGovernorUserDefined entity) {
    LOGGER.info("handling emitFindTurbineGovernorUserDefined");

    queryUpdateEmitter.emit(
        FindTurbineGovernorUserDefinedQuery.class,
        query ->
            query
                .getFilter()
                .getTurbineGovernorUserDefinedId()
                .equals(entity.getTurbineGovernorUserDefinedId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllTurbineGovernorUserDefined
   *
   * @param entity TurbineGovernorUserDefined
   */
  protected void emitFindAllTurbineGovernorUserDefined(TurbineGovernorUserDefined entity) {
    LOGGER.info("handling emitFindAllTurbineGovernorUserDefined");

    queryUpdateEmitter.emit(FindAllTurbineGovernorUserDefinedQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(TurbineGovernorUserDefinedProjector.class.getName());
}
