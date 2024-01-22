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
 * Projector for PFVArControllerType1UserDefined as outlined for the CQRS pattern. All event
 * handling and query handling related to PFVArControllerType1UserDefined are invoked here and
 * dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PFVArControllerType1UserDefinedAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pFVArControllerType1UserDefined")
@Component("pFVArControllerType1UserDefined-projector")
public class PFVArControllerType1UserDefinedProjector
    extends PFVArControllerType1UserDefinedEntityProjector {

  // core constructor
  public PFVArControllerType1UserDefinedProjector(
      PFVArControllerType1UserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePFVArControllerType1UserDefinedEvent
   */
  @EventHandler(payloadType = CreatePFVArControllerType1UserDefinedEvent.class)
  public void handle(CreatePFVArControllerType1UserDefinedEvent event) {
    LOGGER.info("handling CreatePFVArControllerType1UserDefinedEvent - " + event);
    PFVArControllerType1UserDefined entity = new PFVArControllerType1UserDefined();
    entity.setPFVArControllerType1UserDefinedId(event.getPFVArControllerType1UserDefinedId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArControllerType1UserDefined(entity);
  }

  /*
   * @param	event UpdatePFVArControllerType1UserDefinedEvent
   */
  @EventHandler(payloadType = UpdatePFVArControllerType1UserDefinedEvent.class)
  public void handle(UpdatePFVArControllerType1UserDefinedEvent event) {
    LOGGER.info("handling UpdatePFVArControllerType1UserDefinedEvent - " + event);

    PFVArControllerType1UserDefined entity = new PFVArControllerType1UserDefined();
    entity.setPFVArControllerType1UserDefinedId(event.getPFVArControllerType1UserDefinedId());
    entity.setProprietary(event.getProprietary());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArControllerType1UserDefined(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArControllerType1UserDefined(entity);
  }

  /*
   * @param	event DeletePFVArControllerType1UserDefinedEvent
   */
  @EventHandler(payloadType = DeletePFVArControllerType1UserDefinedEvent.class)
  public void handle(DeletePFVArControllerType1UserDefinedEvent event) {
    LOGGER.info("handling DeletePFVArControllerType1UserDefinedEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PFVArControllerType1UserDefined entity = delete(event.getPFVArControllerType1UserDefinedId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArControllerType1UserDefined(entity);
  }

  /*
   * @param	event AssignProprietaryToPFVArControllerType1UserDefinedEvent
   */
  @EventHandler(payloadType = AssignProprietaryToPFVArControllerType1UserDefinedEvent.class)
  public void handle(AssignProprietaryToPFVArControllerType1UserDefinedEvent event) {
    LOGGER.info("handling AssignProprietaryToPFVArControllerType1UserDefinedEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArControllerType1UserDefined entity =
        assignProprietary(event.getPFVArControllerType1UserDefinedId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArControllerType1UserDefined(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArControllerType1UserDefined(entity);
  }

  /*
   * @param	event UnAssignProprietaryFromPFVArControllerType1UserDefinedEvent
   */
  @EventHandler(payloadType = UnAssignProprietaryFromPFVArControllerType1UserDefinedEvent.class)
  public void handle(UnAssignProprietaryFromPFVArControllerType1UserDefinedEvent event) {
    LOGGER.info("handling UnAssignProprietaryFromPFVArControllerType1UserDefinedEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArControllerType1UserDefined entity =
        unAssignProprietary(event.getPFVArControllerType1UserDefinedId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArControllerType1UserDefined(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArControllerType1UserDefined(entity);
  }

  /**
   * Method to retrieve the PFVArControllerType1UserDefined via an
   * PFVArControllerType1UserDefinedPrimaryKey.
   *
   * @param id Long
   * @return PFVArControllerType1UserDefined
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PFVArControllerType1UserDefined handle(FindPFVArControllerType1UserDefinedQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPFVArControllerType1UserDefinedId());
  }

  /**
   * Method to retrieve a collection of all PFVArControllerType1UserDefineds
   *
   * @param query FindAllPFVArControllerType1UserDefinedQuery
   * @return List<PFVArControllerType1UserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PFVArControllerType1UserDefined> handle(
      FindAllPFVArControllerType1UserDefinedQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPFVArControllerType1UserDefined, but only if the id
   * matches
   *
   * @param entity PFVArControllerType1UserDefined
   */
  protected void emitFindPFVArControllerType1UserDefined(PFVArControllerType1UserDefined entity) {
    LOGGER.info("handling emitFindPFVArControllerType1UserDefined");

    queryUpdateEmitter.emit(
        FindPFVArControllerType1UserDefinedQuery.class,
        query ->
            query
                .getFilter()
                .getPFVArControllerType1UserDefinedId()
                .equals(entity.getPFVArControllerType1UserDefinedId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPFVArControllerType1UserDefined
   *
   * @param entity PFVArControllerType1UserDefined
   */
  protected void emitFindAllPFVArControllerType1UserDefined(
      PFVArControllerType1UserDefined entity) {
    LOGGER.info("handling emitFindAllPFVArControllerType1UserDefined");

    queryUpdateEmitter.emit(
        FindAllPFVArControllerType1UserDefinedQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType1UserDefinedProjector.class.getName());
}
