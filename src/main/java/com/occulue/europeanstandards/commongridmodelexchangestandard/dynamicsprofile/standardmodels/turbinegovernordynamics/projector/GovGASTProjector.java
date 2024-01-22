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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GovGAST as outlined for the CQRS pattern. All event handling and query handling
 * related to GovGAST are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovGASTAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govGAST")
@Component("govGAST-projector")
public class GovGASTProjector extends GovGASTEntityProjector {

  // core constructor
  public GovGASTProjector(GovGASTRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovGASTEvent
   */
  @EventHandler(payloadType = CreateGovGASTEvent.class)
  public void handle(CreateGovGASTEvent event) {
    LOGGER.info("handling CreateGovGASTEvent - " + event);
    GovGAST entity = new GovGAST();
    entity.setGovGASTId(event.getGovGASTId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UpdateGovGASTEvent
   */
  @EventHandler(payloadType = UpdateGovGASTEvent.class)
  public void handle(UpdateGovGASTEvent event) {
    LOGGER.info("handling UpdateGovGASTEvent - " + event);

    GovGAST entity = new GovGAST();
    entity.setGovGASTId(event.getGovGASTId());
    entity.setAt(event.getAt());
    entity.setDturb(event.getDturb());
    entity.setKt(event.getKt());
    entity.setMwbase(event.getMwbase());
    entity.setR(event.getR());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setVmax(event.getVmax());
    entity.setVmin(event.getVmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event DeleteGovGASTEvent
   */
  @EventHandler(payloadType = DeleteGovGASTEvent.class)
  public void handle(DeleteGovGASTEvent event) {
    LOGGER.info("handling DeleteGovGASTEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovGAST entity = delete(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignAtToGovGASTEvent
   */
  @EventHandler(payloadType = AssignAtToGovGASTEvent.class)
  public void handle(AssignAtToGovGASTEvent event) {
    LOGGER.info("handling AssignAtToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignAt(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignAtFromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignAtFromGovGASTEvent.class)
  public void handle(UnAssignAtFromGovGASTEvent event) {
    LOGGER.info("handling UnAssignAtFromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignAt(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignDturbToGovGASTEvent
   */
  @EventHandler(payloadType = AssignDturbToGovGASTEvent.class)
  public void handle(AssignDturbToGovGASTEvent event) {
    LOGGER.info("handling AssignDturbToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignDturb(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignDturbFromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignDturbFromGovGASTEvent.class)
  public void handle(UnAssignDturbFromGovGASTEvent event) {
    LOGGER.info("handling UnAssignDturbFromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignDturb(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignKtToGovGASTEvent
   */
  @EventHandler(payloadType = AssignKtToGovGASTEvent.class)
  public void handle(AssignKtToGovGASTEvent event) {
    LOGGER.info("handling AssignKtToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignKt(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignKtFromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignKtFromGovGASTEvent.class)
  public void handle(UnAssignKtFromGovGASTEvent event) {
    LOGGER.info("handling UnAssignKtFromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignKt(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignMwbaseToGovGASTEvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovGASTEvent.class)
  public void handle(AssignMwbaseToGovGASTEvent event) {
    LOGGER.info("handling AssignMwbaseToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignMwbase(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovGASTEvent.class)
  public void handle(UnAssignMwbaseFromGovGASTEvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignMwbase(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignRToGovGASTEvent
   */
  @EventHandler(payloadType = AssignRToGovGASTEvent.class)
  public void handle(AssignRToGovGASTEvent event) {
    LOGGER.info("handling AssignRToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignR(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignRFromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignRFromGovGASTEvent.class)
  public void handle(UnAssignRFromGovGASTEvent event) {
    LOGGER.info("handling UnAssignRFromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignR(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignT1ToGovGASTEvent
   */
  @EventHandler(payloadType = AssignT1ToGovGASTEvent.class)
  public void handle(AssignT1ToGovGASTEvent event) {
    LOGGER.info("handling AssignT1ToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignT1(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignT1FromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignT1FromGovGASTEvent.class)
  public void handle(UnAssignT1FromGovGASTEvent event) {
    LOGGER.info("handling UnAssignT1FromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignT1(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignT2ToGovGASTEvent
   */
  @EventHandler(payloadType = AssignT2ToGovGASTEvent.class)
  public void handle(AssignT2ToGovGASTEvent event) {
    LOGGER.info("handling AssignT2ToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignT2(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignT2FromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignT2FromGovGASTEvent.class)
  public void handle(UnAssignT2FromGovGASTEvent event) {
    LOGGER.info("handling UnAssignT2FromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignT2(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignT3ToGovGASTEvent
   */
  @EventHandler(payloadType = AssignT3ToGovGASTEvent.class)
  public void handle(AssignT3ToGovGASTEvent event) {
    LOGGER.info("handling AssignT3ToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignT3(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignT3FromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignT3FromGovGASTEvent.class)
  public void handle(UnAssignT3FromGovGASTEvent event) {
    LOGGER.info("handling UnAssignT3FromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignT3(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignVmaxToGovGASTEvent
   */
  @EventHandler(payloadType = AssignVmaxToGovGASTEvent.class)
  public void handle(AssignVmaxToGovGASTEvent event) {
    LOGGER.info("handling AssignVmaxToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignVmax(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignVmaxFromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignVmaxFromGovGASTEvent.class)
  public void handle(UnAssignVmaxFromGovGASTEvent event) {
    LOGGER.info("handling UnAssignVmaxFromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignVmax(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event AssignVminToGovGASTEvent
   */
  @EventHandler(payloadType = AssignVminToGovGASTEvent.class)
  public void handle(AssignVminToGovGASTEvent event) {
    LOGGER.info("handling AssignVminToGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST entity = assignVmin(event.getGovGASTId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /*
   * @param	event UnAssignVminFromGovGASTEvent
   */
  @EventHandler(payloadType = UnAssignVminFromGovGASTEvent.class)
  public void handle(UnAssignVminFromGovGASTEvent event) {
    LOGGER.info("handling UnAssignVminFromGovGASTEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST entity = unAssignVmin(event.getGovGASTId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST(entity);
  }

  /**
   * Method to retrieve the GovGAST via an GovGASTPrimaryKey.
   *
   * @param id Long
   * @return GovGAST
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovGAST handle(FindGovGASTQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovGASTId());
  }

  /**
   * Method to retrieve a collection of all GovGASTs
   *
   * @param query FindAllGovGASTQuery
   * @return List<GovGAST>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovGAST> handle(FindAllGovGASTQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovGAST, but only if the id matches
   *
   * @param entity GovGAST
   */
  protected void emitFindGovGAST(GovGAST entity) {
    LOGGER.info("handling emitFindGovGAST");

    queryUpdateEmitter.emit(
        FindGovGASTQuery.class,
        query -> query.getFilter().getGovGASTId().equals(entity.getGovGASTId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovGAST
   *
   * @param entity GovGAST
   */
  protected void emitFindAllGovGAST(GovGAST entity) {
    LOGGER.info("handling emitFindAllGovGAST");

    queryUpdateEmitter.emit(FindAllGovGASTQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovGASTProjector.class.getName());
}
