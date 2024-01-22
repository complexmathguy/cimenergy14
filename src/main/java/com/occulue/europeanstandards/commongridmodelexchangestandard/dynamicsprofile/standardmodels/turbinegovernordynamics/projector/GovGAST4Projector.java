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
 * Projector for GovGAST4 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovGAST4 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovGAST4Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govGAST4")
@Component("govGAST4-projector")
public class GovGAST4Projector extends GovGAST4EntityProjector {

  // core constructor
  public GovGAST4Projector(GovGAST4Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovGAST4Event
   */
  @EventHandler(payloadType = CreateGovGAST4Event.class)
  public void handle(CreateGovGAST4Event event) {
    LOGGER.info("handling CreateGovGAST4Event - " + event);
    GovGAST4 entity = new GovGAST4();
    entity.setGovGAST4Id(event.getGovGAST4Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UpdateGovGAST4Event
   */
  @EventHandler(payloadType = UpdateGovGAST4Event.class)
  public void handle(UpdateGovGAST4Event event) {
    LOGGER.info("handling UpdateGovGAST4Event - " + event);

    GovGAST4 entity = new GovGAST4();
    entity.setGovGAST4Id(event.getGovGAST4Id());
    entity.setBp(event.getBp());
    entity.setKtm(event.getKtm());
    entity.setMnef(event.getMnef());
    entity.setMxef(event.getMxef());
    entity.setRymn(event.getRymn());
    entity.setRymx(event.getRymx());
    entity.setTa(event.getTa());
    entity.setTc(event.getTc());
    entity.setTcm(event.getTcm());
    entity.setTm(event.getTm());
    entity.setTv(event.getTv());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event DeleteGovGAST4Event
   */
  @EventHandler(payloadType = DeleteGovGAST4Event.class)
  public void handle(DeleteGovGAST4Event event) {
    LOGGER.info("handling DeleteGovGAST4Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovGAST4 entity = delete(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignBpToGovGAST4Event
   */
  @EventHandler(payloadType = AssignBpToGovGAST4Event.class)
  public void handle(AssignBpToGovGAST4Event event) {
    LOGGER.info("handling AssignBpToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignBp(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignBpFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignBpFromGovGAST4Event.class)
  public void handle(UnAssignBpFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignBpFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignBp(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignKtmToGovGAST4Event
   */
  @EventHandler(payloadType = AssignKtmToGovGAST4Event.class)
  public void handle(AssignKtmToGovGAST4Event event) {
    LOGGER.info("handling AssignKtmToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignKtm(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignKtmFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignKtmFromGovGAST4Event.class)
  public void handle(UnAssignKtmFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignKtmFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignKtm(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignMnefToGovGAST4Event
   */
  @EventHandler(payloadType = AssignMnefToGovGAST4Event.class)
  public void handle(AssignMnefToGovGAST4Event event) {
    LOGGER.info("handling AssignMnefToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignMnef(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignMnefFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignMnefFromGovGAST4Event.class)
  public void handle(UnAssignMnefFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignMnefFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignMnef(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignMxefToGovGAST4Event
   */
  @EventHandler(payloadType = AssignMxefToGovGAST4Event.class)
  public void handle(AssignMxefToGovGAST4Event event) {
    LOGGER.info("handling AssignMxefToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignMxef(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignMxefFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignMxefFromGovGAST4Event.class)
  public void handle(UnAssignMxefFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignMxefFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignMxef(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignRymnToGovGAST4Event
   */
  @EventHandler(payloadType = AssignRymnToGovGAST4Event.class)
  public void handle(AssignRymnToGovGAST4Event event) {
    LOGGER.info("handling AssignRymnToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignRymn(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignRymnFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignRymnFromGovGAST4Event.class)
  public void handle(UnAssignRymnFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignRymnFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignRymn(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignRymxToGovGAST4Event
   */
  @EventHandler(payloadType = AssignRymxToGovGAST4Event.class)
  public void handle(AssignRymxToGovGAST4Event event) {
    LOGGER.info("handling AssignRymxToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignRymx(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignRymxFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignRymxFromGovGAST4Event.class)
  public void handle(UnAssignRymxFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignRymxFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignRymx(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignTaToGovGAST4Event
   */
  @EventHandler(payloadType = AssignTaToGovGAST4Event.class)
  public void handle(AssignTaToGovGAST4Event event) {
    LOGGER.info("handling AssignTaToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignTa(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignTaFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignTaFromGovGAST4Event.class)
  public void handle(UnAssignTaFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignTaFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignTa(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignTcToGovGAST4Event
   */
  @EventHandler(payloadType = AssignTcToGovGAST4Event.class)
  public void handle(AssignTcToGovGAST4Event event) {
    LOGGER.info("handling AssignTcToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignTc(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignTcFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignTcFromGovGAST4Event.class)
  public void handle(UnAssignTcFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignTcFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignTc(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignTcmToGovGAST4Event
   */
  @EventHandler(payloadType = AssignTcmToGovGAST4Event.class)
  public void handle(AssignTcmToGovGAST4Event event) {
    LOGGER.info("handling AssignTcmToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignTcm(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignTcmFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignTcmFromGovGAST4Event.class)
  public void handle(UnAssignTcmFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignTcmFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignTcm(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignTmToGovGAST4Event
   */
  @EventHandler(payloadType = AssignTmToGovGAST4Event.class)
  public void handle(AssignTmToGovGAST4Event event) {
    LOGGER.info("handling AssignTmToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignTm(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignTmFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignTmFromGovGAST4Event.class)
  public void handle(UnAssignTmFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignTmFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignTm(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event AssignTvToGovGAST4Event
   */
  @EventHandler(payloadType = AssignTvToGovGAST4Event.class)
  public void handle(AssignTvToGovGAST4Event event) {
    LOGGER.info("handling AssignTvToGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST4 entity = assignTv(event.getGovGAST4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /*
   * @param	event UnAssignTvFromGovGAST4Event
   */
  @EventHandler(payloadType = UnAssignTvFromGovGAST4Event.class)
  public void handle(UnAssignTvFromGovGAST4Event event) {
    LOGGER.info("handling UnAssignTvFromGovGAST4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST4 entity = unAssignTv(event.getGovGAST4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST4(entity);
  }

  /**
   * Method to retrieve the GovGAST4 via an GovGAST4PrimaryKey.
   *
   * @param id Long
   * @return GovGAST4
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovGAST4 handle(FindGovGAST4Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovGAST4Id());
  }

  /**
   * Method to retrieve a collection of all GovGAST4s
   *
   * @param query FindAllGovGAST4Query
   * @return List<GovGAST4>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovGAST4> handle(FindAllGovGAST4Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovGAST4, but only if the id matches
   *
   * @param entity GovGAST4
   */
  protected void emitFindGovGAST4(GovGAST4 entity) {
    LOGGER.info("handling emitFindGovGAST4");

    queryUpdateEmitter.emit(
        FindGovGAST4Query.class,
        query -> query.getFilter().getGovGAST4Id().equals(entity.getGovGAST4Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovGAST4
   *
   * @param entity GovGAST4
   */
  protected void emitFindAllGovGAST4(GovGAST4 entity) {
    LOGGER.info("handling emitFindAllGovGAST4");

    queryUpdateEmitter.emit(FindAllGovGAST4Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovGAST4Projector.class.getName());
}
