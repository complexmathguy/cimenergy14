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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.validator.*;
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
 * PFVArControllerType1UserDefined business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of PFVArControllerType1UserDefined related services in the case of
 *       a PFVArControllerType1UserDefined business related service failing.
 *   <li>Exposes a simpler, uniform PFVArControllerType1UserDefined interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       PFVArControllerType1UserDefined business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class PFVArControllerType1UserDefinedBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public PFVArControllerType1UserDefinedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * PFVArControllerType1UserDefined Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return PFVArControllerType1UserDefinedBusinessDelegate
   */
  public static PFVArControllerType1UserDefinedBusinessDelegate
      getPFVArControllerType1UserDefinedInstance() {
    return (new PFVArControllerType1UserDefinedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createPFVArControllerType1UserDefined(
      CreatePFVArControllerType1UserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getPFVArControllerType1UserDefinedId() == null)
        command.setPFVArControllerType1UserDefinedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArControllerType1UserDefinedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreatePFVArControllerType1UserDefinedCommand - by convention the future return
      // value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreatePFVArControllerType1UserDefinedCommand of PFVArControllerType1UserDefined is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create PFVArControllerType1UserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdatePFVArControllerType1UserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updatePFVArControllerType1UserDefined(
      UpdatePFVArControllerType1UserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      PFVArControllerType1UserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdatePFVArControllerType1UserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save PFVArControllerType1UserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeletePFVArControllerType1UserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeletePFVArControllerType1UserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArControllerType1UserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeletePFVArControllerType1UserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete PFVArControllerType1UserDefined using Id = "
              + command.getPFVArControllerType1UserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the PFVArControllerType1UserDefined via
   * PFVArControllerType1UserDefinedFetchOneSummary
   *
   * @param summary PFVArControllerType1UserDefinedFetchOneSummary
   * @return PFVArControllerType1UserDefinedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public PFVArControllerType1UserDefined getPFVArControllerType1UserDefined(
      PFVArControllerType1UserDefinedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "PFVArControllerType1UserDefinedFetchOneSummary arg cannot be null");

    PFVArControllerType1UserDefined entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      PFVArControllerType1UserDefinedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a PFVArControllerType1UserDefined
      // --------------------------------------
      CompletableFuture<PFVArControllerType1UserDefined> futureEntity =
          queryGateway.query(
              new FindPFVArControllerType1UserDefinedQuery(
                  new LoadPFVArControllerType1UserDefinedFilter(
                      summary.getPFVArControllerType1UserDefinedId())),
              ResponseTypes.instanceOf(PFVArControllerType1UserDefined.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate PFVArControllerType1UserDefined with id "
              + summary.getPFVArControllerType1UserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all PFVArControllerType1UserDefineds
   *
   * @return List<PFVArControllerType1UserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  public List<PFVArControllerType1UserDefined> getAllPFVArControllerType1UserDefined()
      throws ProcessingException {
    List<PFVArControllerType1UserDefined> list = null;

    try {
      CompletableFuture<List<PFVArControllerType1UserDefined>> futureList =
          queryGateway.query(
              new FindAllPFVArControllerType1UserDefinedQuery(),
              ResponseTypes.multipleInstancesOf(PFVArControllerType1UserDefined.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all PFVArControllerType1UserDefined";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Proprietary on PFVArControllerType1UserDefined
   *
   * @param command AssignProprietaryToPFVArControllerType1UserDefinedCommand
   * @exception ProcessingException
   */
  public void assignProprietary(AssignProprietaryToPFVArControllerType1UserDefinedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getPFVArControllerType1UserDefinedId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    PFVArControllerType1UserDefinedBusinessDelegate parentDelegate =
        PFVArControllerType1UserDefinedBusinessDelegate
            .getPFVArControllerType1UserDefinedInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      PFVArControllerType1UserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Proprietary on PFVArControllerType1UserDefined
   *
   * @param command UnAssignProprietaryFromPFVArControllerType1UserDefinedCommand
   * @exception ProcessingException
   */
  public void unAssignProprietary(
      UnAssignProprietaryFromPFVArControllerType1UserDefinedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      PFVArControllerType1UserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Proprietary on PFVArControllerType1UserDefined";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return PFVArControllerType1UserDefined
   */
  private PFVArControllerType1UserDefined load(UUID id) throws ProcessingException {
    pFVArControllerType1UserDefined =
        PFVArControllerType1UserDefinedBusinessDelegate.getPFVArControllerType1UserDefinedInstance()
            .getPFVArControllerType1UserDefined(
                new PFVArControllerType1UserDefinedFetchOneSummary(id));
    return pFVArControllerType1UserDefined;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private PFVArControllerType1UserDefined pFVArControllerType1UserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(PFVArControllerType1UserDefinedBusinessDelegate.class.getName());
}
