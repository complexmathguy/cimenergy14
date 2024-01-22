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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * PhaseTapChangerTabular business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PhaseTapChangerTabular related services in the case of a
 *       PhaseTapChangerTabular business related service failing.
 *   <li>Exposes a simpler, uniform PhaseTapChangerTabular interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill PhaseTapChangerTabular
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PhaseTapChangerTabularBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PhaseTapChangerTabularBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PhaseTapChangerTabular Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PhaseTapChangerTabularBusinessDelegate
   */
  public static PhaseTapChangerTabularBusinessDelegate getPhaseTapChangerTabularInstance() {
    return (new PhaseTapChangerTabularBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPhaseTapChangerTabular(
      CreatePhaseTapChangerTabularCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPhaseTapChangerTabularId() == null)
        command.setPhaseTapChangerTabularId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerTabularValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePhaseTapChangerTabularCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePhaseTapChangerTabularCommand of PhaseTapChangerTabular is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PhaseTapChangerTabular - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePhaseTapChangerTabularCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePhaseTapChangerTabular(
      UpdatePhaseTapChangerTabularCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PhaseTapChangerTabularValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePhaseTapChangerTabularCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PhaseTapChangerTabular - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePhaseTapChangerTabularCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePhaseTapChangerTabularCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerTabularValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePhaseTapChangerTabularCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PhaseTapChangerTabular using Id = "
              + command.getPhaseTapChangerTabularId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PhaseTapChangerTabular via PhaseTapChangerTabularFetchOneSummary
   *
   * @param summary PhaseTapChangerTabularFetchOneSummary
   * @return PhaseTapChangerTabularFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PhaseTapChangerTabular getPhaseTapChangerTabular(
      PhaseTapChangerTabularFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "PhaseTapChangerTabularFetchOneSummary arg cannot be null");

    PhaseTapChangerTabular entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PhaseTapChangerTabularValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PhaseTapChangerTabular
      // --------------------------------------
      CompletableFuture<PhaseTapChangerTabular> futureEntity =
          queryGateway.query(
              new FindPhaseTapChangerTabularQuery(
                  new LoadPhaseTapChangerTabularFilter(summary.getPhaseTapChangerTabularId())),
              ResponseTypes.instanceOf(PhaseTapChangerTabular.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PhaseTapChangerTabular with id "
              + summary.getPhaseTapChangerTabularId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PhaseTapChangerTabulars
   *
   * @return List<PhaseTapChangerTabular>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PhaseTapChangerTabular> getAllPhaseTapChangerTabular() throws ProcessingException {
    List<PhaseTapChangerTabular> list = null;

    try {
      CompletableFuture<List<PhaseTapChangerTabular>> futureList =
          queryGateway.query(
              new FindAllPhaseTapChangerTabularQuery(),
              ResponseTypes.multipleInstancesOf(PhaseTapChangerTabular.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PhaseTapChangerTabular";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add PhaseTapChangerTabular to PhaseTapChangerTabular
   *
   * @param command AssignPhaseTapChangerTabularToPhaseTapChangerTabularCommand
   * @exception ProcessingException
   */
  public void addToPhaseTapChangerTabular(
      AssignPhaseTapChangerTabularToPhaseTapChangerTabularCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getPhaseTapChangerTabularId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .PhaseTapChangerTabularBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.PhaseTapChangerTabularBusinessDelegate
                .getPhaseTapChangerTabularInstance();
    PhaseTapChangerTabularBusinessDelegate parentDelegate =
        PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance();
    UUID childId = command.getAddTo().getPhaseTapChangerTabularId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerTabularValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a PhaseTapChangerTabular as PhaseTapChangerTabular to PhaseTapChangerTabular";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove PhaseTapChangerTabular from PhaseTapChangerTabular
   *
   * @param command RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand
   * @exception ProcessingException
   */
  public void removeFromPhaseTapChangerTabular(
      RemovePhaseTapChangerTabularFromPhaseTapChangerTabularCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .PhaseTapChangerTabularBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.PhaseTapChangerTabularBusinessDelegate
                .getPhaseTapChangerTabularInstance();
    UUID childId = command.getRemoveFrom().getPhaseTapChangerTabularId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PhaseTapChangerTabularValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PhaseTapChangerTabular
   */
  private PhaseTapChangerTabular load(UUID id) throws ProcessingException {
    phaseTapChangerTabular =
        PhaseTapChangerTabularBusinessDelegate.getPhaseTapChangerTabularInstance()
            .getPhaseTapChangerTabular(new PhaseTapChangerTabularFetchOneSummary(id));
    return phaseTapChangerTabular;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PhaseTapChangerTabular phaseTapChangerTabular = null;
  private static final Logger LOGGER =
      Logger.getLogger(PhaseTapChangerTabularBusinessDelegate.class.getName());
}
